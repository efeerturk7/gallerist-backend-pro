package com.efeerturk.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AuthRequest {

	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
}
