package com.example.testtask.service;

import java.util.List;
import java.util.Optional;
import com.example.testtask.model.Article;
import com.example.testtask.model.User;

public interface UserService {
    User save(User user);

    List<User> saveAll(List<User> users);

    List<User> findAllByAgeMoreThan(int age);

    List<User> findAllByColor(Article.Color color);

    List<User> findAll();

    List<String> findAllNameByGreaterThanThreeArticles();

    Optional<User> findByName(String name);
}
