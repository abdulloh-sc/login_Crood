package com.example.login.service;

import com.example.login.entity.User;
import com.example.login.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public boolean login(String username, String password) {
        User user = repo.findByUsername(username);
        if (user == null) {
            return false;
        }
        if (user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean register(String username, String password) {
        if (repo.existsByUsername(username)) {
            return false;
        }
        repo.save(new User(null, username, password));
        return true;
    }
}
