package com.example.simpleuserapi.controller;

import com.example.simpleuserapi.dto.UserRequest;
import com.example.simpleuserapi.entity.User;
import com.example.simpleuserapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 単体登録
    @PostMapping("/user")
    public User addUser(@RequestBody @Valid UserRequest req) {
        return userService.createUser(req.getName(), req.getAge());
    }

    // 複数登録
    @PostMapping("/users")
    public List<User> addUsers(@RequestBody @Valid List<@Valid UserRequest> reqs) {
        return userService.createUsers(reqs);
    }

    // 一覧取得
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
