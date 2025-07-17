package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.entities.User;
import com.gestion.apireparaciones.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericServiceImpl<User, Long> {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        super(userRepo);
        this.userRepo = userRepo;
    }


    public User update(Long id, User u) {
        if (!userRepo.existsById(id)) return null;
        u.setId_user(id);
        return userRepo.save(u);
    }
}
