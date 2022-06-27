package com.example.testtask.security;

import com.example.testtask.exception.AuthenticationException;
import com.example.testtask.model.User;

public interface AuthenticationService {
    User register(String name, String password, int age);

    User login(String name, String password) throws AuthenticationException;
}
