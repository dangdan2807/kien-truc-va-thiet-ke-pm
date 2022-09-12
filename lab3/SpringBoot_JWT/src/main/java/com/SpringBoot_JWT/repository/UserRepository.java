package com.SpringBoot_JWT.repository;

import com.SpringBoot_JWT.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
