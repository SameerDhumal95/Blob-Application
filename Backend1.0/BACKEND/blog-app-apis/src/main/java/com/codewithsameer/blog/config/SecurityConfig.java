package com.codewithsameer.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.codewithsameer.blog.security.CustomUserDetailService;
import com.codewithsameer.blog.security.JwtAuthenticationEntryPoint;
import com.codewithsameer.blog.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	  @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	        .csrf()
	        .disable()
	        .authorizeHttpRequests()
	       
	        .anyRequest()
	        .authenticated()
	        .and()
	        .exceptionHandling()
	        .authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
	        .and()
	        .sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        
	        http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	        
	        return http.build();
	    }
	
	  @Bean
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
	  
	  @Bean
	  public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception
	  {
		  return configuration.getAuthenticationManager();
	  }
}
