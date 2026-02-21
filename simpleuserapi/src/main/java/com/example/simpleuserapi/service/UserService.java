package com.example.simpleuserapi.service;

import com.example.simpleuserapi.dto.UserRequest;
import com.example.simpleuserapi.entity.User;
import com.example.simpleuserapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 単体ユーザー登録
    @Transactional
    public User createUser(String name, int age) {
        log.info("  【Service】トランザクション開始");
        log.info("  【Service】ユーザーエンティティ作成: name={}, age={}", name, age);
        User user = new User();
        user.setName(name);
        user.setAge(age);
        log.info("  【Service】Repository.save() 呼び出し");
        User saved = userRepository.save(user);
        log.info("  【Service】DB保存完了: id={}", saved.getId());
        log.info("  【Service】トランザクションコミット");
        return saved;
    }

    // 複数ユーザー登録
    @Transactional
    public List<User> createUsers(List<UserRequest> reqs) {
        log.info("  【Service】トランザクション開始");
        log.info("  【Service】{} 件のユーザーエンティティを作成中", reqs.size());
        List<User> users = reqs.stream().map(r -> {
            User u = new User();
            u.setName(r.getName());
            u.setAge(r.getAge());
            return u;
        }).toList();
        log.info("  【Service】Repository.saveAll() 呼び出し");
        List<User> saved = userRepository.saveAll(users);
        log.info("  【Service】DB一括保存完了: {} 件", saved.size());
        log.info("  【Service】トランザクションコミット");
        return saved;
    }

    // 全ユーザー取得
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        log.info("  【Service】読み取り専用トランザクション開始");
        log.info("  【Service】Repository.findAll() 呼び出し");
        List<User> users = userRepository.findAll();
        log.info("  【Service】DB取得完了: {} 件", users.size());
        return users;
    }
}
