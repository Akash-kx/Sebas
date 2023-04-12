package com.Ecommerce.Sebas.SpringSecurityConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Ecommerce.Sebas.JWTtoken.JwtFilter;

@Configuration
public class SecurityConfiguration {
	
	@Autowired
	private ManuelUserNamePasswordAuthentication AuthenticationManuel;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain defaultSecurityFilterChain( HttpSecurity http ) throws Exception {
		
		String[] AccessAllocate = {"/css/**", "/js/**"};
		
		http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(AccessAllocate).permitAll()
		.requestMatchers("/AddProductInInventory", "/ShowAllProductInInventory", "/ShowSearchedProduct/**", "/ShowAllProductForMen/**", "/ShowAllProductForWomen/**", "/ShowAllSearchedProduct/**" ,"/ShowOnlySpecificProduct").permitAll()
		.requestMatchers("/ShowRegistrationForm", "/UserRegistrationInformation").permitAll()
		.requestMatchers("/AddProductInWishList", "/ShowAllProductInWishList" ,"/DeleteSpecificProductInWishList/**", "/AddProductInAddToBagFromWishList/**", "/AddProductInAddToBag").permitAll()
		.requestMatchers("/ShowAllProductInAddToBag", "/DeleteSpecificProductInAddToBag/**", "/MoveProductToWishList/**", "/UpdateProductInAddToBag/**").permitAll()	
		.requestMatchers("/DeleteSpecificProductInAddToBag/**", "/MoveProductToWishList/**", "/UpdateProductInAddToBag", "/ShowAllProductIdInAddToBag", "/MoveProductToYourOrder/**").permitAll()
		.requestMatchers("/ShowAllProductInYourOrder", "/DeleteSpecificProductInYourOrder/**").permitAll()
		.requestMatchers("/AddLoginInformation").permitAll()
		.requestMatchers("/UserCardDetail").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().formLogin().loginPage("http://localhost:4200/LoginPage").usernameParameter("userEmail").usernameParameter("userPassword")
		.and().logout().logoutUrl("/LogoutPage").logoutSuccessUrl("http://localhost:4200/HomePage").permitAll()
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager( HttpSecurity http ) throws Exception {

		System.out.println("Inside ManuelAuthenticationCall");
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(AuthenticationManuel);
		return authenticationManagerBuilder.build();
	}

}
