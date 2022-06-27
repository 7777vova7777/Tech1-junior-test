package com.example.testtask.security;

import java.util.Optional;
import com.example.testtask.exception.AuthenticationException;
import com.example.testtask.model.User;
import com.example.testtask.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String name, String password, int age) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setAge(age);
        return userService.save(user);
    }

    @Override
    public User login(String name, String password) throws AuthenticationException {
        Optional<User> user = userService.findByName(name);
        String encodedPassword = passwordEncoder.encode(password);
        if (user.isEmpty() || user.get().getPassword().equals(encodedPassword)) {
            throw new AuthenticationException("Incorrect username or password!!!");
        }
        return user.get();
    }
}
