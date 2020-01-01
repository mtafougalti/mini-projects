package com.mt.mp.articlesmanagement;

import com.mt.mp.articlesmanagement.entities.Article;
import com.mt.mp.articlesmanagement.repositories.ArticleRepository;
import com.mt.mp.articlesmanagement.services.ArticleService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Log
public class AppInitializer implements CommandLineRunner {
    @Autowired
    private ArticleService articleService;

    @Override
    public void run(String... args) throws Exception {
        if(articleService.findAll().isEmpty()){
            articleService.save(new Article(1L, "Google", "www.google.fr"));
            articleService.save(new Article(2L, "Yahoo", "www.yahoo.fr"));
        }

        articleService.findAll().forEach(a -> {
            log.info(a.toString());
        });
    }
}
