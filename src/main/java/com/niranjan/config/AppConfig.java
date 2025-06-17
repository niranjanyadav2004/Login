package com.niranjan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

	/*@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User.builder().username("Niranjan").password(passwordEncoder().encode("nii")).build();
		UserDetails user2 = User.builder().username("Nandinee").password(passwordEncoder().encode("nandu")).build();
		
		return new InMemoryUserDetailsManager(user1,user2);
	}*/
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
