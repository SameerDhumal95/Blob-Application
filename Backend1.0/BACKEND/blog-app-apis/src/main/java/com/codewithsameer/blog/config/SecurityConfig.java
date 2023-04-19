package com.codewithsameer.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.codewithsameer.blog.security.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	
	  @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	        .csrf()
	        .disable()
	        .authorizeHttpRequests()
	        .anyRequest()
	        .authenticated()
	        .and()
	        .httpBasic();
	        return http.build();
	    }
	
	  public PasswordEncoder passwordEncoder()
	  {
		  return new BCryptPasswordEncoder();
	  }
	  
	  
	  @Bean
	  public DaoAuthenticationProvider daoAuthenticationProvider()
	  {
		  DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		  provider.setUserDetailsService(this.customUserDetailService);
		  provider.setPasswordEncoder(passwordEncoder());
		  return provider;
	  }
	  
//	  @Bean
//	  public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception
//	  {
//		  return configuration.getAuthenticationManager();
//	  }
}
