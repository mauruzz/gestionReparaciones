package com.gestion.apireparaciones.controllers;

import com.gestion.apireparaciones.entities.User;
import com.gestion.apireparaciones.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return userRepo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public User create(@RequestBody User u) {
        return userRepo.save(u);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User u) {

        if (!userRepo.existsById(id)) return ResponseEntity.notFound().build();

        u.setId_user(id);
        return ResponseEntity.ok(userRepo.save(u));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!userRepo.existsById(id)) return ResponseEntity.notFound().build();

        userRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
