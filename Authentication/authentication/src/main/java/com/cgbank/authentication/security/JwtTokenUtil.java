package com.cgbank.authentication.security;

import java.io.Serializable;
import com.cgbank.commonservices.security.JwtConfig;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
	
	static final String CLAM_KEY_USERNAME = "sub";
	static final String CLAM_KEY_AUDIENCE =" aud";
	static final String CLAM_KEY_CREATED = "created";


	
	@Value ("${jwt.secret}")
	private String secret;
	
	@Value ("${jwt.expiration}")
	private String expiration;
	
	private final JwtConfig jwtConfig;
	
	public JwtTokenUtil(JwtConfig jwtConfig) {
		this.jwtConfig = jwtConfig;
	}
	
	public String getUserNameFromToken(String token) {
		String username = null;
		try {
			final Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
			
			
		}catch (Exception e) {
			username= null;
		}
		
		return null;
	}
	
	private Claims getClaimsFromToken(String token) {
		Claims claims = null;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		}catch(Exception e) {
			claims = null;
		}
		
		return claims;
	}

	public boolean validateToken(String authToken, UserDetails userDetails) {
		// TODO Auto-generated method stub
		
		JwtUser user = (JwtUser) userDetails;
		final String username = getUserNameFromToken(authToken);
		
		return (username.equals(user.getUsername()) && !isTokenExpired(authToken));
	}

	private boolean isTokenExpired(String authToken) {
		final Date expiration = getExpirationDateFromToken(authToken);
		
		return expiration.before(new Date());
	}

	private Date getExpirationDateFromToken(String authToken) {

		Date expiration = null;
		try {
			final Claims claims = getClaimsFromToken(authToken);
			if(claims != null) {
				expiration = claims.getExpiration();
			}else {
				expiration = null;
			}
		}catch(Exception e) {
			expiration = null;
		}
		return expiration;
	}

	public String generateToken(JwtUser userDetails, Authentication auth) {
		Map <String, Object> claims = new HashMap<String, Object>();
		claims.put(CLAM_KEY_USERNAME, userDetails.getUsername());
		claims.put(CLAM_KEY_CREATED, new Date());
		return generateToken(claims, userDetails, auth);
	}

	private String generateToken(Map<String, Object> claims, JwtUser userDetails, Authentication auth) {
		
		Long now = System.currentTimeMillis();
		return Jwts.builder()
				.setSubject(auth.getName())
				.claim("authorities", auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(now))
				.setExpiration(generateExpirationDate())
				.signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())
				.compact();
	}

	private Date generateExpirationDate() {
		
		
		return new Date(System.currentTimeMillis() + Long.valueOf(expiration) * 1000);
	}

}
