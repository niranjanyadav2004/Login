package com.niranjan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.niranjan.entities.User;
import com.niranjan.repo.UserRepository;

@Service
public class CustomeUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username).orElseThrow(()->new RuntimeException("User not found...!!!"));
		return user;
	}

}
