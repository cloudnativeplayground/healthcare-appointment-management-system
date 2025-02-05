package com.cloudnativeplayground.healthcare.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private static final String SECRET_KEY = "your_super_secret_key_which_should_be_long"; // Replace with a strong secret key
    private static final long EXPIRATION_TIME = 86400000; // 1 day

    private final Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));

    /**
     * Generates a JWT token for an authenticated user.
     */
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    /**
     * Parses and validates a JWT token.
     */
    public Claims parseToken(String token) {
        return Jwts.parser() // ✅ This works in JJWT 0.12.x
                .verifyWith((SecretKey) key) // ✅ Replaces `setSigningKey()`
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Validates a JWT token.
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = parseToken(token).getSubject();
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return parseToken(token).getExpiration().before(new Date());
    }
}
