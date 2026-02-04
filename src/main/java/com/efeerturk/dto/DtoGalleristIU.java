package com.efeerturk.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoGalleristIU{

	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private Long addressId;
}
