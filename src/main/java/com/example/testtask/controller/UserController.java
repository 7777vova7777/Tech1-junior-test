package com.example.testtask.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.example.testtask.dto.UserResponseDto;
import com.example.testtask.dto.mapper.UserMapper;
import com.example.testtask.model.Article;
import com.example.testtask.model.User;
import com.example.testtask.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/user")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.findAll().stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/age/{age}")
    public List<UserResponseDto> getAllByAgeMoreThan(@PathVariable int age) {
        return userService.findAllByAgeMoreThan(age).stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/articles")
    public List<UserResponseDto> getAllByColor(@RequestParam String color) {
        return userService.findAllByColor(Article.Color.valueOf(color.toUpperCase())).stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/name")
    public List<String> getName() {
        return userService.findAllName();
    }
}
