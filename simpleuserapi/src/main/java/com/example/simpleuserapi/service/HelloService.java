package com.example.simpleuserapi.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String generateGreeting(String name) {
        return "Hello, " + name + "!";
    }
}
