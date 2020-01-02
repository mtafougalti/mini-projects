package com.mt.mp.articlesmanagement.repositories;

import com.mt.mp.articlesmanagement.entities.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AppUserRepository extends MongoRepository<AppUser, String> {

    public Optional<AppUser> findByUsername(String username);
}
