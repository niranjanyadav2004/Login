package com.niranjan.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.niranjan.DTO.SignUpRequest;
import com.niranjan.entities.User;
import com.niranjan.enums.Roles;
import com.niranjan.repo.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void creatAdminAccount() {
		User admin = userRepository.findByRole(Roles.ADMIN);
		if(admin==null) {
		   User user = new User();
		   user.setUserID(UUID.randomUUID().toString());
		   user.setName("admin");
		   user.setEmail("admin@gmail.com");
		   user.setPassword(passwordEncoder.encode("admin"));
		   user.setAbout("I am an admin..!!!");
		   user.setRole(Roles.ADMIN);
		   userRepository.save(user);
		}
	}
	
	public User createUser(SignUpRequest signUpRequest) {
		User user = new User();
		
		user.setUserID(UUID.randomUUID().toString());
		user.setName(signUpRequest.getName());
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		user.setAbout(signUpRequest.getAbout());
		user.setRole(Roles.USER);
		
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	
}
