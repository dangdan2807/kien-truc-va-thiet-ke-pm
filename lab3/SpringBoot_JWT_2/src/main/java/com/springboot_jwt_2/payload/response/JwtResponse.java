package com.springboot_jwt_2.payload.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type;
    private String username;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String token, String type, String username, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.type = type;
        this.username = username;
        this.roles = roles;
    }

    public JwtResponse() {
    }

    public JwtResponse(String token, String username, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.username = username;
        this.type = "Bearer";
        this.roles = authorities;
    }
}
