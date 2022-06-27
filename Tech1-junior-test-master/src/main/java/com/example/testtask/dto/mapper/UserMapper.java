package com.example.testtask.dto.mapper;

import com.example.testtask.dto.UserRegistrationDto;
import com.example.testtask.dto.UserResponseDto;
import com.example.testtask.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToModel(UserRegistrationDto registrationDto) {
        User user = new User();
        user.setName(registrationDto.getName());
        user.setPassword(registrationDto.getPassword());
        return user;
    }

    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setName(user.getName());
        responseDto.setAge(user.getAge());
        responseDto.setArticle(user.getArticle());
        return responseDto;
    }
}
