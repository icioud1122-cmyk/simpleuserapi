package com.example.simpleuserapi.service;

import com.example.simpleuserapi.dto.UserRequest;
import com.example.simpleuserapi.entity.User;
import com.example.simpleuserapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 単体ユーザー登録
    public User createUser(String name, int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return userRepository.save(user);
    }

    // 複数ユーザー登録
    public List<User> createUsers(List<UserRequest> reqs) {
        List<User> users = reqs.stream().map(r -> {
            User u = new User();
            u.setName(r.getName());
            u.setAge(r.getAge());
            return u;
        }).toList();
        return userRepository.saveAll(users);
    }

    // 全ユーザー取得
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
