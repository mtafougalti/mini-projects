package com.mt.mp.articlesmanagement.controllers;

import com.mt.mp.articlesmanagement.entities.Article;
import com.mt.mp.articlesmanagement.exceptions.NotFoundException;
import com.mt.mp.articlesmanagement.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<Article>> list() {
        List<Article> result = articleService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Article> add(@Validated @RequestBody Article article) {
        articleService.save(article);
        return new ResponseEntity(article, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getById(@PathVariable Long id) {
        Article article = articleService.findById(id);
        return new ResponseEntity(article, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        articleService.delete(articleService.findById(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
