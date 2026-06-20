package com.example.login.service;

import com.example.login.entity.User;
import com.example.login.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> findAll(){
        return repo.findAll();
    }
    public User findById(Long id){
        return repo.findById(id);
    }

    public User create(String username, String password){
        return repo.save(new User(null,username,password));
    }

    public User update(Long id, String username, String password){
        return repo.update(id,username,password);
    }

    public boolean delete(Long id){
        return repo.deleteById(id);
    }










}
