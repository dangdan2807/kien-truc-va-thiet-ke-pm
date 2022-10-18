package com.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class HomeController {
    // [GET] /
    @GetMapping("/")
    public String home() {
        return "hello";
    }
}
