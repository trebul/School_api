package com.example.api.config;

import com.example.api.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
}
