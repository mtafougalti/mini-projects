package com.mt.mp.articlesmanagement.repositories;

import com.mt.mp.articlesmanagement.entities.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends MongoRepository<Article, Long> {
   public Optional<Article> findByTitle(String title);
}
