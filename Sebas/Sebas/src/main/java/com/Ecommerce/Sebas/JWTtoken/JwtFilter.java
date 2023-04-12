package com.Ecommerce.Sebas.JWTtoken;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Ecommerce.Sebas.CRUDRepository.RegistrationRepository;
import com.Ecommerce.Sebas.DetailInformation.RegistrationInformation;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
    @Autowired
    private JwtUtil jwtUtil;
    
	@Autowired
	private RegistrationRepository RegisterationFormRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		String AuthorizationHeader = request.getHeader("Authorization");
		
        String Token = null;
        String UserName = null;
        
        if (AuthorizationHeader != null && AuthorizationHeader.startsWith("Bearer ")) {
        	
        	Token = AuthorizationHeader.substring(7);
        	UserName = jwtUtil.extractUsername(Token);
        }
        
        if (UserName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        	
            RegistrationInformation UserDetail = RegisterationFormRepository.EmailAndPasswordLogin(UserName).orElseThrow(() -> new NullPointerException("Not found"));
            
            System.out.println("Inside doFilterInternal");
            
            if (jwtUtil.validateToken(Token, UserDetail)) {
            	
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(UserDetail.getEmailId() ,UserDetail.getUserPassword(), new ArrayList<>());
                
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        
        filterChain.doFilter(request, response);
    }
}
