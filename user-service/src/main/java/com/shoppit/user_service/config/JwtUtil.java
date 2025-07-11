package com.shoppit.user_service.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private final long expiration = 86400000; // 24h

    public String generateToken(String subject) {
        final Date currentDate = new Date();
        final Date expirationDate = new Date(currentDate.getTime() + expiration);
        System.out.println("Token will expire at: " + expirationDate);

        return Jwts.builder()
                .subject(subject)
                .issuedAt(currentDate)
                .expiration(expirationDate)
                .signWith(SECRET_KEY)
                .compact();
    }
}
