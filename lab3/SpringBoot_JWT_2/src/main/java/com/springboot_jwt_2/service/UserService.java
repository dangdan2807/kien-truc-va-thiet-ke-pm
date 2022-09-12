package com.springboot_jwt_2.service;

import com.springboot_jwt_2.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    Boolean existByUsername(String username);
    User save(User user);
}
