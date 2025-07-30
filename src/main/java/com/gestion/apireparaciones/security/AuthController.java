package com.gestion.apireparaciones.security;

import com.gestion.apireparaciones.entities.User;
import com.gestion.apireparaciones.repositories.UserRepository;
import com.gestion.apireparaciones.security.dto.LoginRequest;
import com.gestion.apireparaciones.security.dto.LoginResponse;
import com.gestion.apireparaciones.security.jwt.JwtUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/auth")
    public class AuthController {

        private final AuthenticationManager authManager;
        private final JwtUtils jwtUtils;
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;

        public AuthController(AuthenticationManager authManager,
                              JwtUtils jwtUtils,
                              UserRepository userRepository,
                              PasswordEncoder passwordEncoder) {
            this.authManager = authManager;
            this.jwtUtils = jwtUtils;
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody LoginRequest request) {
            try {
                // Autentica credenciales (esto invoca a UserDetailsServiceImpl)
                Authentication auth = authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
                );

                // Si autenticó, buscamos el usuario para role/type y generamos el token
                User user = userRepository.getUserByUsername(request.getUsername())
                        .orElseThrow(() -> new BadCredentialsException("Usuario no encontrado"));

                String token = jwtUtils.generateJwtToken(
                        new CustomUserDetails(user)  // reutilizamos el adaptador
                );

                long expiresIn = jwtUtils.getExpirationMs(); // agregamos un getter en JwtUtils (ver abajo)
                return ResponseEntity.ok(
                        new LoginResponse(token, expiresIn, user.getUsername(), user.getType())
                );

            } catch (BadCredentialsException ex) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
            }
        }

        // (Opcional) Registro básico — guarda password con BCrypt
        @PostMapping("/register")
        public ResponseEntity<?> register(@RequestBody User user) {
            if (userRepository.getUserByUsername(user.getUsername()).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario ya existe");
            }
            user.setPassword(passwordEncoder.encode(user.getPassword())); // importante
            if (user.getType() == null) user.setType("INVITADO"); // default
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }


    }
