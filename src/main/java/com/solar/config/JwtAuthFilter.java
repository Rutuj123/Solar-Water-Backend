package com.solar.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.solar.service.CustomUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter{
    
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader=request.getHeader("Authorization");
		if(authHeader !=null && authHeader.startsWith("Bearer ")) {
			try {
			String token=authHeader.substring(7);
			String username=jwtUtil.extractUsername(token);
			if(username!=null && SecurityContextHolder.getContext().getAuthentication() ==null) {
				UserDetails userDetails=userDetailsService.loadUserByUsername(username);
				if(jwtUtil.isTokenValid(token)) {
					
					UsernamePasswordAuthenticationToken auth=
							     new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					SecurityContextHolder.getContext().setAuthentication(auth);
				}
			}
			}catch (ExpiredJwtException ex) {
			    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			    response.getWriter().write("Token Expired");
			    return;
			}
		}
		filterChain.doFilter(request, response);
	}
	
	@Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
       // return request.getServletPath().equals("/auth/login");
		String path = request.getServletPath();

		/*
		 * return path.equals("api/auth/login") || path.startsWith("api/api/leads");
		 */   /// use this when you use dockerize application
	    return path.equals("/auth/login")
		        || path.startsWith("/api/leads");

    }


}
