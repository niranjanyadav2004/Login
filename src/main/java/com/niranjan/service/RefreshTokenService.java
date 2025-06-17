package com.niranjan.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niranjan.entities.RefreshToken;
import com.niranjan.entities.User;
import com.niranjan.repo.RefreshTokenRepository;
import com.niranjan.repo.UserRepository;

@Service
public class RefreshTokenService {
	
	private long refreshTokenValidity = 10*60*60*1000;

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public RefreshToken createRefreshToken(String userName){
		User user = userRepository.findByEmail(userName).get();
		
		RefreshToken refreshToken1 = user.getRefreshToken();

		if(refreshToken1==null) {
			 refreshToken1=RefreshToken.builder()
			                           .refresToken(UUID.randomUUID().toString())
			                           .expiry(Instant.now().plusMillis(refreshTokenValidity))
			                           .user(user)
			                           .build();
		}
		else {
			refreshToken1.setExpiry(Instant.now().plusMillis(refreshTokenValidity));
		}
		
		user.setRefreshToken(refreshToken1);
		
	    refreshTokenRepository.save(refreshToken1);
		
		return refreshToken1;
	}
	
	public RefreshToken verifyRefreshToken(String refreshToken) {
		RefreshToken refreshTokenOb = refreshTokenRepository.findByRefresToken(refreshToken).orElseThrow(()-> new RuntimeException("Token does not exist..!!!"));
		
		if(refreshTokenOb.getExpiry().compareTo(Instant.now()) < 0) {
			refreshTokenRepository.delete(refreshTokenOb);
			throw new RuntimeException("Refresh token expired..!!!");
		}

        return refreshTokenOb;
	}
	
}
