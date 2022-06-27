package com.example.testtask.controller;

import java.util.Map;
import com.example.testtask.dto.UserLoginDto;
import com.example.testtask.dto.UserRegistrationDto;
import com.example.testtask.dto.UserResponseDto;
import com.example.testtask.dto.mapper.UserMapper;
import com.example.testtask.exception.AuthenticationException;
import com.example.testtask.model.User;
import com.example.testtask.security.AuthenticationService;
import com.example.testtask.security.jwt.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserMapper userMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    JwtTokenProvider jwtTokenProvider, UserMapper userMapper) {
        this.authenticationService = authenticationService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginDto userLoginDto)
            throws AuthenticationException {
        User user = authenticationService.login(userLoginDto.getName(), userLoginDto.getPassword());
        String token = jwtTokenProvider.createToken(user.getName());
        return new ResponseEntity<>(Map.of("token",token), HttpStatus.OK);
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRegistrationDto registrationDto) {
        User user = authenticationService.register(registrationDto.getName(),
                registrationDto.getPassword(), registrationDto.getAge());
        return userMapper.mapToDto(user);
    }
}
