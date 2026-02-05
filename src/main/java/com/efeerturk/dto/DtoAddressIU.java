package com.efeerturk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DtoAddressIU {

	@NotBlank
	private String city;
	
	@NotBlank
	private String district;
	
	@NotBlank
	private String neighborhood;
	
	@NotBlank
	private String street;
}
