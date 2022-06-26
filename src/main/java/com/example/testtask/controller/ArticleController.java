package com.example.testtask.controller;

import com.example.testtask.model.Article;
import com.example.testtask.service.ArticleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/article")
    public Article save(@RequestBody Article article) {
        return articleService.save(article);
    }
}
