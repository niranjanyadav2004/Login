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
public class SignUpRequest {

	private String name;
	private String email;
	private String password;
	private String about;
	
}
