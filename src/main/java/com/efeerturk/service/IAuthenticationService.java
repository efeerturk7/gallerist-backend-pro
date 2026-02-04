package com.efeerturk.service;

import com.efeerturk.dto.AuthRequest;
import com.efeerturk.dto.AuthResponse;
import com.efeerturk.dto.DtoUser;
import com.efeerturk.dto.RefreshTokenRequest;

public interface IAuthenticationService {

	public DtoUser register(AuthRequest input);
	
	public AuthResponse authenticate(AuthRequest input);
	
	public AuthResponse refreshToken(RefreshTokenRequest input);
}
