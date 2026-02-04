package com.efeerturk.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

	private String accessToken;
	
	private String refreshToken;
}
