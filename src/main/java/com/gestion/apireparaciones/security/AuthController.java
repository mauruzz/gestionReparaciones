package com.gestion.apireparaciones.security;

import com.gestion.apireparaciones.security.dto.RegisterRequest;
import com.gestion.apireparaciones.services.UserService;
import jakarta.validation.Valid;
import com.gestion.apireparaciones.entities.User;
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

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Value("${jwt.expirationMs}")
    private long expirationMs;

    // Registro de usuario
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {

        if (!userService.isUsernameAvailable(request.getUsername())) {
            return ResponseEntity.badRequest().body("Ya existe un usuario con ese nombre");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setType(request.getType());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setBranch(request.getBranch());

        userService.save(user);
        return ResponseEntity.ok("Usuario registrado con éxito");
    }


    // Login de usuario
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
        Optional<User> user = userService.getUserByUsername(userDetails.getUsername());

        LoginResponse response = new LoginResponse(jwt, expirationMs, userDetails.getUsername(), role, user.get().getId_user(), user.get().getName(), user.get().getEmail(), user.get().getBranch());

        return ResponseEntity.ok(response);
    }



}
