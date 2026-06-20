package com.example.login.repository;

import com.example.login.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class UserRepository {

    private final Map<String, User> data = new HashMap<>();

    private Long nextId = 1L;

    public UserRepository() {
        save(new User(null, "admin", "1234"));
        save(new User(null, "ali", "parol"));
    }

    public User findByUsername(String username) {
        return data.get(username);
    }

    public boolean existsByUsername(String username) {
        return data.containsKey(username);
    }

    public User save(User user) {
        User toSave = new User(nextId, user.getUsername(), user.getPassword());
        data.put(toSave.getUsername(), toSave);
        nextId = nextId + 1;
        return toSave;
    }
}
