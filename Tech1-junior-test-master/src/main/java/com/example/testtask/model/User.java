package com.example.testtask.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private int age;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Article> article;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
