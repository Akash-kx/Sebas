package com.Ecommerce.Sebas.JWTtoken;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.Ecommerce.Sebas.DetailInformation.RegistrationInformation;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

    private String secret = "akash";

    public String extractUsername(String token) {
    	
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
    	
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    	
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
    	
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
    	
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String username) {
    	
    	System.out.println("Inside generate token");
        Map<String, Object> claims = new HashMap<>(); //Need Some Changes
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
    	
    	System.out.println("Inside create token");
    	return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
    			.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
    			.signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Boolean validateToken(String token, RegistrationInformation userDetails) {
    	
    	System.out.println("Inside validate token");
        final String username = extractUsername(token);
        return (username.equals(userDetails.getEmailId()) && !isTokenExpired(token)); //Need Some Changes
    }
}
