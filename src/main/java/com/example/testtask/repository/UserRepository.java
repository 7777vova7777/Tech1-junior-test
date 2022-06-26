package com.example.testtask.repository;

import java.util.List;
import java.util.Optional;
import com.example.testtask.model.Article;
import com.example.testtask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>,
        JpaSpecificationExecutor<User> {

    @Query("select u from User u where u.age > ?1")
    List<User> findAllByAgeGreaterThan(int age);

    @Query("select u from User u left join fetch u.article ua where ua.color = ?1")
    List<User> findAllByArticleContains(Article.Color color);

    @Query("select u.name from User u where u.article.size > 3")
    List<String> findAllName();

    Optional<User> findByName(String name);

}
