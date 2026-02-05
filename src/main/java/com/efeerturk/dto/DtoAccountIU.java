package com.efeerturk.dto;

import java.math.BigDecimal;

import com.efeerturk.enums.CurrencyType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DtoAccountIU {

	@NotBlank
	private String accountNo;
	
	@NotBlank
	private String iban;
	
	@NotNull
	private BigDecimal amount;
	
	@NotNull
	private CurrencyType currencyType;
}
