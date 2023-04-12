package com.Ecommerce.Sebas.MainController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Sebas.DetailInformation.LoginInformation;
import com.Ecommerce.Sebas.JWTtoken.JwtUtil;

@CrossOrigin(origins="*")
@RestController
public class LoginFormController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/AddLoginInformation")
	public String AddLoginInformation(@RequestBody LoginInformation LoginDetail) {
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(LoginDetail.getUserEmail(), LoginDetail.getUserPassword(), new ArrayList<>()));
		}
		catch(Exception e) {
			
			e.printStackTrace();
			return "Not valid username or password";
		}
		
		return jwtUtil.generateToken(LoginDetail.getUserEmail());
	}
}