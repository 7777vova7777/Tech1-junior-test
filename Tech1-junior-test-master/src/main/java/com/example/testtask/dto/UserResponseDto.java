package com.example.testtask.dto;

import java.util.List;
import com.example.testtask.model.Article;
import lombok.Data;

@Data
public class UserResponseDto {
    private String name;
    private int age;
    private List<Article> article;
}
