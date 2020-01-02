package com.mt.mp.articlesmanagement;

import com.mt.mp.articlesmanagement.entities.AppUser;
import com.mt.mp.articlesmanagement.entities.Article;
import com.mt.mp.articlesmanagement.repositories.ArticleRepository;
import com.mt.mp.articlesmanagement.services.AppUserService;
import com.mt.mp.articlesmanagement.services.ArticleService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Log
public class AppInitializer implements CommandLineRunner {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private AppUserService appUserService;

    @Override
    public void run(String... args) throws Exception {
        if(articleService.findAll().isEmpty()){
            articleService.save(new Article(1L, "Google", "www.google.fr"));
            articleService.save(new Article(2L, "Yahoo", "www.yahoo.fr"));
        }

        log.info("Articles List ...");
        articleService.findAll().forEach(a -> {
            log.info(a.toString());
        });

        if(appUserService.findAll().isEmpty()){
            appUserService.save(new AppUser(1L, "admin", "test", true, Arrays.asList("ADMIN", "USER")));
            appUserService.save(new AppUser(2L, "user", "test", true, Arrays.asList("USER")));
        }

        log.info("Users List ...");
        appUserService.findAll().forEach(a -> {
            log.info(a.toString());
        });
    }
}
