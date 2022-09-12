package com.springboot_jwt_2.controller;

import com.springboot_jwt_2.entity.Role;
import com.springboot_jwt_2.entity.User;
import com.springboot_jwt_2.payload.request.RegisterRequest;
import com.springboot_jwt_2.payload.response.MessageResponse;
import com.springboot_jwt_2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    /*
     * đầu nào
     * username
     * password
     * roles
     * */
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
                    Role adminRole = roleService.findByName("ADMIN").orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(adminRole);
                    break;
                case "pm":
                case "PM":
                    Role pmRole = roleService.findByName("PM").orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleService.findByName("USER").orElseThrow(() -> new RuntimeException("Role not found"));
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
}
