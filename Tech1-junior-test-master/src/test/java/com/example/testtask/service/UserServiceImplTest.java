package com.example.testtask.service;

import java.util.List;
import com.example.testtask.model.User;
import com.example.testtask.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;

    @Test
    void shouldReturnFindAllByAgeMoreThan() {
        Mockito.when(userRepository.findAllByAgeGreaterThan(21))
                .thenReturn(List.of(new User("Bob", 23), new User("Alice", 21)));
        List<User> actual = userService.findAllByAgeMoreThan(21);
        Assertions.assertEquals(2, actual.size());
        Assertions.assertEquals("Bob", actual.get(0).getName());
    }
}