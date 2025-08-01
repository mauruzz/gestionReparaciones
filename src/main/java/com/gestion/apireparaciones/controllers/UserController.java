package com.gestion.apireparaciones.controllers;

import com.gestion.apireparaciones.dto.UserDTO;
import com.gestion.apireparaciones.dto.UserMapper;
import com.gestion.apireparaciones.entities.User;
import com.gestion.apireparaciones.security.dto.RegisterRequest;
import com.gestion.apireparaciones.security.dto.RegisterRequestMapper;
import com.gestion.apireparaciones.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final RegisterRequestMapper registerRequestMapper;

    public UserController(UserService userService, UserMapper userMapper, RegisterRequestMapper registerRequestMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.registerRequestMapper = registerRequestMapper;
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<User> u = userService.findAll();
        List<UserDTO> dtos = u.stream().map(userMapper::toDTO).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        User u = userService.findById(id);
        return (u != null)  ? ResponseEntity.ok(userMapper.toDTO(u))
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto) {
        User saved = userService.save(userMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO dto) {
        User u = userService.update(id, userMapper.toEntity(dto));
        return (u != null)  ? ResponseEntity.ok(userMapper.toDTO(u))
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (userService.findById(id) != null){
            userService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegisterRequest> updateWithPassword(@PathVariable Long id, @Valid @RequestBody RegisterRequest dto) {
        /*User u = userService.update(id, registerRequestMapper.toEntity(dto));
        return (u != null)  ? ResponseEntity.ok(registerRequestMapper.toDTO(u))
                : ResponseEntity.notFound().build();


         */
        try {
            User u = userService.update(id, registerRequestMapper.toEntity(dto));
            return ResponseEntity.ok(registerRequestMapper.toDTO(u)).;
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el usuario");
        }

    }
}
