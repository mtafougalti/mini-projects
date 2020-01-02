package com.mt.mp.articlesmanagement.services;

import com.mt.mp.articlesmanagement.entities.AppUser;
import com.mt.mp.articlesmanagement.exceptions.NotFoundException;
import com.mt.mp.articlesmanagement.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> optionalUser = appUserRepository.findByUsername(username);
        if(!optionalUser.isPresent()){
            throw new NotFoundException("Username not found");
        }
        return optionalUser.get();
    }

    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    public AppUser save(AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return appUserRepository.save(user);
    }

    public Optional<AppUser> findById(String id) {
        return appUserRepository.findById(id);
    }

    public void delete(AppUser user) {
        appUserRepository.delete(user);
    }
}
