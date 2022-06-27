package com.example.testtask.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.testtask.model.Article;
import com.example.testtask.model.User;
import com.example.testtask.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> saveAll(List<User> userList) {
        return userRepository.saveAll(userList.stream()
                .peek(user -> user.setPassword(passwordEncoder.encode(user.getPassword())))
                .collect(Collectors.toList()));
    }

    @Override
    public List<User> findAllByAgeMoreThan(int age) {
        return userRepository.findAllByAgeGreaterThan(age);
    }

    @Override
    public List<User> findAllByColor(Article.Color color) {
        return userRepository.findAllByArticleContains(color);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<String> findAllNameByGreaterThanThreeArticles() {
        return userRepository.findAllNameByGreaterThanThreeArticle();
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }
}
