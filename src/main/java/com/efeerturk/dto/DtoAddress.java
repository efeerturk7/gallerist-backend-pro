package com.efeerturk.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DtoAddress extends DtoBase{

	private String city;
	
	private String district;
	
	private String neighborhood;
	
	private String street;
}
