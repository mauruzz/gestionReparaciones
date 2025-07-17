package com.gestion.apireparaciones.controllers;

import com.gestion.apireparaciones.entities.Status;
import com.gestion.apireparaciones.entities.User;
import com.gestion.apireparaciones.repositories.UserRepository;
import com.gestion.apireparaciones.services.StatusServiceImpl;
import com.gestion.apireparaciones.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all")
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User u = userService.findById(id);
        return (u != null)  ? ResponseEntity.ok(u)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public User create(@RequestBody User u) {
        return userService.save(u);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        User u = userService.update(id, user);
        return (u != null)  ? ResponseEntity.ok(u)
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

}
