package com.SpringBoot_JWT.repository;

import com.SpringBoot_JWT.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository
        extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
