package com.example.simpleuserapi.controller;

import com.example.simpleuserapi.dto.UserRequest;
import com.example.simpleuserapi.entity.User;
import com.example.simpleuserapi.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 単体登録
    @PostMapping("/user")
    public User addUser(@RequestBody @Valid UserRequest req) {
        log.info("========================================");
        log.info("【Controller】POST /user - ユーザー登録開始");
        log.info("【Controller】リクエストデータ: name={}, age={}", req.getName(), req.getAge());
        User result = userService.createUser(req.getName(), req.getAge());
        log.info("【Controller】ユーザー登録完了: id={}", result.getId());
        log.info("========================================");
        return result;
    }

    // 複数登録
    @PostMapping("/users")
    public List<User> addUsers(@RequestBody @Valid List<@Valid UserRequest> reqs) {
        log.info("========================================");
        log.info("【Controller】POST /users - 複数ユーザー登録開始");
        log.info("【Controller】リクエスト件数: {}", reqs.size());
        List<User> result = userService.createUsers(reqs);
        log.info("【Controller】複数ユーザー登録完了: {} 件", result.size());
        log.info("========================================");
        return result;
    }

    // 一覧取得
    @GetMapping("/users")
    public List<User> getUsers() {
        log.info("========================================");
        log.info("【Controller】GET /users - ユーザー一覧取得開始");
        List<User> result = userService.getAllUsers();
        log.info("【Controller】ユーザー一覧取得完了: {} 件", result.size());
        log.info("========================================");
        return result;
    }
}
