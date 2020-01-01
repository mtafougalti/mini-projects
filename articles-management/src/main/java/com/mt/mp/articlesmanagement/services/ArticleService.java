package com.mt.mp.articlesmanagement.services;

import com.mt.mp.articlesmanagement.entities.Article;
import com.mt.mp.articlesmanagement.exceptions.AlreadyExistsException;
import com.mt.mp.articlesmanagement.exceptions.NotFoundException;
import com.mt.mp.articlesmanagement.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article save(Article article) {
        Optional<Article> articleOptional = articleRepository.findByTitle(article.getTitle());
        if(articleOptional.isPresent()){
            throw new AlreadyExistsException(String.format("An article with title = %s already exists.", article.getTitle()));
        }
        return articleRepository.save(article);
    }

    public Article findById(Long id) {
        try {
            return articleRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new NotFoundException(String.format("No article with the id %s was found.", id));
        }
    }

    public void delete(Article article) {
        articleRepository.delete(article);
    }
}
