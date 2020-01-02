package com.mt.mp.articlesmanagement.security;

import com.mt.mp.articlesmanagement.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {

    private static final String TOKEN_HEADER = "Authorization";

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private AppUserService appUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(TOKEN_HEADER);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if(header != null && securityContext.getAuthentication() == null){
            String token = header.substring("Bearer ".length());
            String username = jwtTokenUtils.getUsernameFromToken(token);
            if(username != null) {
                UserDetails user = appUserService.loadUserByUsername(username);
                if(jwtTokenUtils.isTokenValid(token, user)){
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    securityContext.setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
