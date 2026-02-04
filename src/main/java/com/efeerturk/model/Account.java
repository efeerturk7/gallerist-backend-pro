package com.efeerturk.model;

import java.math.BigDecimal;

import com.efeerturk.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity{


	private String accountNo;
	

	private String iban;
	

	private BigDecimal amount;
	

	@Enumerated(EnumType.STRING)
	private CurrencyType currencyType;
	
}
