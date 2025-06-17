package com.niranjan.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JwtResponse {

	private String jwtToken;
	private String refreshToken;
	private String username;
	private String role;
	
}
