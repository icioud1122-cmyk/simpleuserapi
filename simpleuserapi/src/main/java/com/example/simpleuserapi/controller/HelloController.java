package com.example.simpleuserapi.controller;

import com.example.simpleuserapi.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @PostMapping("/json-greet")
    public String greet(@RequestBody User user) {
        return "Hello, " + user.getName() + "!";
    }
}
