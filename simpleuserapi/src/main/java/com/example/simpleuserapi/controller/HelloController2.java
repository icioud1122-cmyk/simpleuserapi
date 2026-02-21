package com.example.simpleuserapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController2 {

    private static final Logger log = LoggerFactory.getLogger(HelloController2.class);

    @GetMapping("/hello")
    public String sayHello() {
        log.info("========================================");
        log.info("【Controller】GET /hello - Hello実行開始");
        String result = "Hello, JAVA!!!!";
        log.info("【Controller】レスポンス: {}", result);
        log.info("========================================");
        return result;
    }
}
