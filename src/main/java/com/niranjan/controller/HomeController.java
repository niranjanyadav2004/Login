package com.niranjan.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niranjan.entities.User;
import com.niranjan.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}
	
}
