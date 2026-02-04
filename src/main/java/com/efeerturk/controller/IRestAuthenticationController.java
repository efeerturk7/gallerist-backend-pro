package com.efeerturk.controller;

import com.efeerturk.dto.AuthRequest;
import com.efeerturk.dto.AuthResponse;
import com.efeerturk.dto.DtoUser;
import com.efeerturk.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {

	public RootEntity<DtoUser> register(AuthRequest input);
	
	public RootEntity<AuthResponse> authenticate(AuthRequest input);
	
	public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
}
