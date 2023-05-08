package com.shopkeeperbilling.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class JwtTokenUtil {

    @org.springframework.beans.factory.annotation.Value("${jwt.secret}")
    private String secretKey;
    @org.springframework.beans.factory.annotation.Value("${jwt.expiration}")
    private Long expiration;

    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_AUDIENCE = "audience";
    static final String CLAIM_KEY_CREATED = "created";

    public String getNameFromToken(String authToken){
        String emailId;
        try {
            final Claims claims = getClaimsFromToken(authToken);
            if(Objects.nonNull(claims)){
                emailId = claims.getSubject();
            }
            else {
                emailId = null;
            }
        }catch (IllegalArgumentException argumentException){
            emailId = null;
            System.out.println("Illegal Argument Exception.");
        }

        return emailId;
    }

    private Claims getClaimsFromToken(String authToken) {
         Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(authToken)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, email);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    public String generateToken(Map<String,Object> claims){

        return Jwts.builder().setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.ES512,secretKey)
                .compact();
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }
}
