package com.example.login.controller;

import com.example.login.dto.LoginRequest;
import com.example.login.entity.User;
import com.example.login.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping
    public List<User> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(Long id){
        User user = service.findById(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody LoginRequest request){
        User created = service.create(request.getUsername(),request.getPassword());
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody LoginRequest request){
        User updated = service.update(id,request.getUsername(),request.getPassword());
        if (updated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean deleted = service.delete(id);
        if (!deleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }




}
