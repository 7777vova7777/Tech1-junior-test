package com.example.testtask.controller;

import javax.annotation.PostConstruct;
import java.util.List;
import com.example.testtask.model.Article;
import com.example.testtask.model.User;
import com.example.testtask.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class InjectController {
    private final UserService userService;

    public InjectController(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public List<User> saveAll() {
        return userService.saveAll(injectUsers());
    }

    public List<User> injectUsers() {
        User userFirst = new User();
        userFirst.setName("Bob");
        userFirst.setAge(21);
        userFirst.setPassword("1111");

        User userSecond = new User();
        userSecond.setName("Alice");
        userSecond.setAge(18);
        userSecond.setPassword("2222");

        User userThird = new User();
        userThird.setName("Tom");
        userThird.setAge(28);
        userThird.setPassword("3333");

        User userForth = new User();
        userForth.setName("Ilon");
        userForth.setAge(52);
        userForth.setPassword("4444");

        User userFifth = new User();
        userFifth.setName("Iren");
        userFifth.setAge(35);
        userFifth.setPassword("5555");

        Article articleFirst = new Article();
        articleFirst.setColor(Article.Color.BLACK);
        articleFirst.setText("night");

        Article articleSecond = new Article();
        articleSecond.setColor(Article.Color.YELLOW);
        articleSecond.setText("sun");

        Article articleThird = new Article();
        articleThird.setColor(Article.Color.GREEN);
        articleThird.setText("wood");

        Article articleForth = new Article();
        articleForth.setColor(Article.Color.BLUE);
        articleForth.setText("sky");

        Article articleFifth = new Article();
        articleFifth.setColor(Article.Color.RED);
        articleFifth.setText("blood");

        Article articleSixth = new Article();
        articleSixth.setColor(Article.Color.RED);
        articleSixth.setText("hahaha");

        Article articleSeventh = new Article();
        articleSeventh.setColor(Article.Color.YELLOW);
        articleSeventh.setText("sun");

        Article articleEighth = new Article();
        articleEighth.setColor(Article.Color.BLACK);
        articleEighth.setText("eighth");

        userFirst.setArticle(List.of(articleFirst, articleForth, articleSixth, articleSeventh));
        userSecond.setArticle(List.of(articleSecond));
        userThird.setArticle(List.of(articleFifth));
        userForth.setArticle(List.of(articleThird));
        userFifth.setArticle(List.of(articleEighth));

        return List.of(userFirst, userSecond, userThird, userForth, userFifth);
    }
}
