package com.gestion.apireparaciones.security;

import com.gestion.apireparaciones.security.dto.RegisterRequest;
import jakarta.validation.Valid;
import com.gestion.apireparaciones.entities.User;
import com.gestion.apireparaciones.repositories.UserRepository;
import com.gestion.apireparaciones.security.dto.LoginRequest;
import com.gestion.apireparaciones.security.dto.LoginResponse;
import com.gestion.apireparaciones.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Value("${jwt.expirationMs}")
    private long expirationMs;

    // Registro de usuario
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("El nombre de usuario ya existe.");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setType(request.getType());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setBranch(request.getBranch());

        userRepository.save(user);

        return ResponseEntity.ok("Usuario registrado con éxito.");
    }


    // 👉 Login de usuario
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwtToken(userDetails.getUsername(), userDetails.getType());
        String role = userDetails.getType();

        LoginResponse response = new LoginResponse(jwt, expirationMs, userDetails.getUsername(), role);

        return ResponseEntity.ok(response);
    }



}
