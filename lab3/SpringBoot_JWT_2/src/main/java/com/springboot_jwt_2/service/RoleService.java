package com.springboot_jwt_2.service;

import com.springboot_jwt_2.entity.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(String name);
}
