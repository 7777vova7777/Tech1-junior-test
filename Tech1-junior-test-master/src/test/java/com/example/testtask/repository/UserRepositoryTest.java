package com.example.testtask.repository;

import java.util.List;
import com.example.testtask.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
//    @Container
//    static MySQLContainer<?> database = new MySQLContainer<>("mysql:8")
//            .withDatabaseName("springboot")
//            .withPassword("springboot")
//            .withUsername("springboot");
//
//    @DynamicPropertySource
//    static void setDatasourceProperties(DynamicPropertyRegistry propertyRegistry) {
//        propertyRegistry.add("spring.datasource.url", database::getJdbcUrl);
//        propertyRegistry.add("spring.datasource.password", database::getPassword);
//        propertyRegistry.add("spring.datasource.username", database::getUsername);
//    }

    @Autowired
    private UserRepository userRepository;

    @Test
    @Sql("/scripts/init_three_users.sql")
    void shouldReturnUserAgeGreaterThan21() {
        List<User> actual = userRepository.findAllByAgeGreaterThan(21);
        Assertions.assertEquals(1, actual.size());
        Assertions.assertEquals("Bob", actual.get(0).getName());
    }

    @Test
    @Sql("/scripts/init_three_users.sql")
    void shouldReturnUserAgeGreaterThan20() {
        List<User> actual = userRepository.findAllByAgeGreaterThan(20);
        Assertions.assertEquals(2, actual.size());
        Assertions.assertEquals("Bob", actual.get(0).getName());
        Assertions.assertEquals("Ilon", actual.get(1).getName());
    }
}