package com.efeerturk.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DtoUser extends DtoBase{

	private String username;
	
	private String password;
}
