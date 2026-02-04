package com.efeerturk.dto;

import java.math.BigDecimal;

import com.efeerturk.enums.CurrencyType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DtoAccount extends DtoBase{

	private String accountNo;
	
	private String iban;
	
	private BigDecimal amount;
	
	private CurrencyType currencyType;
}
