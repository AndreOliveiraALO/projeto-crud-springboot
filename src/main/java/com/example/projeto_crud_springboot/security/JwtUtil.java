package com.example.projeto_crud_springboot.security;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long ExPIRATION_TIME = 86400000;
    
    
    // gera o token
    public static String generateToken(String login){
        return Jwts.builder()
            .setSubject(login)
            .setExpiration(new Date(System.currentTimeMillis()+ ExPIRATION_TIME))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }

    // extrai o usuario
    public static String ExtractLogin(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    // valida o token    
    public static boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    } 


}
