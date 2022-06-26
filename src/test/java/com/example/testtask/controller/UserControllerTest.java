package com.example.testtask.controller;


import java.util.List;
import com.example.testtask.model.User;
import com.example.testtask.service.UserService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    public void shouldShowAllUsers() {
        List<User> mockUsers = List.of(
                new User("Bob", 23),
                new User("Alice", 28),
                new User("Ilon", 55)
        );
        Mockito.when(userService.findAll()).thenReturn(mockUsers);

        RestAssuredMockMvc.when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("size()", Matchers.equalTo(3))
                .body("[0].name", Matchers.equalTo("Bob"))
                .body("[0].age", Matchers.equalTo(23))
                .body("[1].name", Matchers.equalTo("Alice"))
                .body("[1].age", Matchers.equalTo(28))
                .body("[2].name", Matchers.equalTo("Ilon"))
                .body("[2].age", Matchers.equalTo(55));
    }
}