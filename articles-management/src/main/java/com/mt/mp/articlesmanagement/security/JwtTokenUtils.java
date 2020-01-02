package com.mt.mp.articlesmanagement.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtils {

    private static final Long TOKEN_VALIDITY = 604800L;
    private static final String TOKEN_SECRET_KEY = "testsecret";

    public String generateToken(UserDetails user) {
        return Jwts.builder()
                .setClaims(buildClaims(user))
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET_KEY)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                   .setSigningKey(TOKEN_SECRET_KEY)
                   .parseClaimsJws(token)
                   .getBody();
    }

    private Map<String, Object> buildClaims(UserDetails user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", user.getUsername());
        claims.put("created", LocalDateTime.now());
        return claims;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000);
    }

    public boolean isTokenValid(String token, UserDetails user) {
        String username = getUsernameFromToken(token);
        Date expirationDate = getExpirationDateFromToken(token);
        return user.getUsername().equals(username) && expirationDate.after(new Date());
    }

    private Date getExpirationDateFromToken(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            return claims.getExpiration();
        } catch (Exception e) {
            return null;
        }
    }
}
