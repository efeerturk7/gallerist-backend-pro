package com.efeerturk.gallery_project.controller;

import com.efeerturk.gallery_project.dto.AuthRequest;
import com.efeerturk.gallery_project.dto.AuthResponse;
import com.efeerturk.gallery_project.dto.DtoUser;
import com.efeerturk.gallery_project.dto.RefreshTokenRequest;
import com.efeerturk.gallery_project.service.AuthenticationService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RestAuthenticationController extends RestBaseController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")

    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.register(input));
    }

    @PostMapping("/authenticate")

    public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.authenticate(input));
    }

    @PostMapping("/refreshToken")

    public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest input) {
        return ok(authenticationService.refreshToken(input));
    }
}
