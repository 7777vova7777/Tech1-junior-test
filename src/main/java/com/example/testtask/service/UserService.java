package com.example.testtask.service;

import java.util.List;
import java.util.Optional;
import com.example.testtask.model.Article;
import com.example.testtask.model.User;

public interface UserService {
    User save(User user);//4

    List<User> saveAll(List<User> users);//0

    List<User> findAllByAgeMoreThan(int age);//1

    List<User> findAllByColor(Article.Color color);//2

    List<User> findAll();

    List<String> findAllName();//3

    Optional<User> findByName(String name);
}
