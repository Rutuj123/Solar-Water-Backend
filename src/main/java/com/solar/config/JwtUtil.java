package com.solar.config;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
private final String SECRET_KEY="MySuperSecretKeyForJwtWhichIsVerySecure12345";
private Key getKey() {
	return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
}
public String generateToken(String username,String role) {
	return Jwts.builder()
			.setSubject(username)
			.claim("role",role)
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
			.signWith(getKey(),SignatureAlgorithm.HS256)
			.compact();
}

public Claims extractClaims(String token) {
	return Jwts.parserBuilder()
			.setSigningKey(getKey())
			.build()
			.parseClaimsJws(token)
			.getBody();
			
}

public String extractUsername(String token) {
	return extractClaims(token).getSubject();
}

public boolean isTokenValid(String token) {
	return extractClaims(token).getExpiration().after(new Date());
}
}
