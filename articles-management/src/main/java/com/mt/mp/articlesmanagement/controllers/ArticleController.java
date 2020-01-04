package com.mt.mp.articlesmanagement.controllers;

import com.mt.mp.articlesmanagement.entities.Article;
import com.mt.mp.articlesmanagement.exceptions.NotFoundException;
import com.mt.mp.articlesmanagement.services.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/articles")
@Api("Articles API From Annotations")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    @ApiOperation("Get list of all articles")
    public ResponseEntity<List<Article>> list() {
        List<Article> result = articleService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("Add new article")
    public ResponseEntity<Article> add(@Validated @RequestBody Article article) {
        articleService.save(article);
        return new ResponseEntity(article, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get an article by its Id")
    public ResponseEntity<Article> getById(@ApiParam(value = "Id of the article to retrieve", defaultValue = "0") @PathVariable Long id) {
        Article article = articleService.findById(id);
        return new ResponseEntity(article, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete an article")
    public ResponseEntity<Void> delete(@ApiParam(value = "Id of the article to delete", defaultValue = "0") @PathVariable Long id) {
        articleService.delete(articleService.findById(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
