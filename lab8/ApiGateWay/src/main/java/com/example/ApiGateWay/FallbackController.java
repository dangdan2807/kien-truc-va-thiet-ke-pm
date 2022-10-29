package com.example.ApiGateWay;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping(value = "/fallback")
    public ResponseEntity<Object> fallback() {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("message", "Gateway Timeout!");
        return new ResponseEntity<>(
            response,
            org.springframework.http.HttpStatus.GATEWAY_TIMEOUT
        );
    }
    
}
