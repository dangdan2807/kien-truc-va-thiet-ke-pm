package com.springboot_jwt_2.controller;

import com.springboot_jwt_2.entity.Role;
import com.springboot_jwt_2.entity.User;
import com.springboot_jwt_2.payload.request.LoginRequest;
import com.springboot_jwt_2.payload.request.RegisterRequest;
import com.springboot_jwt_2.payload.response.JwtResponse;
import com.springboot_jwt_2.payload.response.MessageResponse;
import com.springboot_jwt_2.security.jwt.JwtProvider;
import com.springboot_jwt_2.security.userpincal.UserPrincipal;
import com.springboot_jwt_2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/")
public class AuthController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    /*
     * đầu nào
     * username: String
     * password: String
     * roles: [String]
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        if (userService.existByUsername(registerRequest.getUsername())) {
            return new ResponseEntity<>(new MessageResponse("the username is existed"), HttpStatus.OK);
        }
        String passEncoder = passwordEncoder.encode(registerRequest.getPassword());
        registerRequest.setPassword(passEncoder);
        User user = new User(registerRequest.getUsername(), passEncoder);
        Set<String> strRoles = registerRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                case "ADMIN":
                    Role adminRole = roleService.findByName("ADMIN")
                            .orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(adminRole);
                    break;
                case "pm":
                case "PM":
                    Role pmRole = roleService.findByName("PM")
                            .orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleService.findByName("USER")
                            .orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(userRole);

            }
        });
        long mili = System.currentTimeMillis();
        user.setCreatedAt(new Date(mili));
        user.setRoles(roles);
        User newUser = userService.save(user);
        // return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        return new ResponseEntity<Object>(newUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(token, userPrincipal.getUsername(), userPrincipal.getAuthorities()));
    }
}
