package com.niranjan.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niranjan.entities.User;
import com.niranjan.enums.Roles;


public interface UserRepository extends JpaRepository<User, String>{

	Optional<User> findByEmail(String email);
	
	User findByRole(Roles role);
	
}
