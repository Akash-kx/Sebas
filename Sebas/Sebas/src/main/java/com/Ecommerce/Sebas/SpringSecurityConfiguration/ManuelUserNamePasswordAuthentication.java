package com.Ecommerce.Sebas.SpringSecurityConfiguration;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.Ecommerce.Sebas.CRUDRepository.RegistrationRepository;
import com.Ecommerce.Sebas.DetailInformation.RegistrationInformation;

@Component
public class ManuelUserNamePasswordAuthentication implements AuthenticationProvider {
	
	@Autowired
	private RegistrationRepository RegisterationFormRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String EmailId= authentication.getName();
		String UserPassword= authentication.getCredentials().toString();
		
		System.out.println("EmailId: " + EmailId + "----" + "UserPassword: " + UserPassword);
		
		RegistrationInformation RegisterationDetail= RegisterationFormRepository.EmailAndPasswordLogin(EmailId).orElseThrow(()-> new NullPointerException("Email not found"));
		
		if(EmailId.equals(RegisterationDetail.getEmailId()) && UserPassword.equals(RegisterationDetail.getUserPassword())) {
			
			return new UsernamePasswordAuthenticationToken(EmailId, UserPassword, new ArrayList<>());
		}
		else {
			
			throw new NullPointerException("Not valid");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
