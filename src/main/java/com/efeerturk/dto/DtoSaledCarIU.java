package com.efeerturk.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DtoSaledCarIU {

	@NotNull
	private Long customerId;
	
	@NotNull
	private Long galleristId;
	
	@NotNull
	private Long carId;
}
