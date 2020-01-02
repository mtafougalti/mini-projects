package com.mt.mp.articlesmanagement.controllers;

import com.mt.mp.articlesmanagement.security.JwtTokenUtils;
import com.mt.mp.articlesmanagement.security.SignInRequest;
import com.mt.mp.articlesmanagement.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value={"", "/"})
    public ResponseEntity<String> sign(@Validated @RequestBody SignInRequest signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = appUserService.loadUserByUsername(signInRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return new ResponseEntity(token, HttpStatus.OK);
    }
}
