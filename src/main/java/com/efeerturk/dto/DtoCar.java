package com.efeerturk.dto;

import java.math.BigDecimal;

import com.efeerturk.enums.CarStatusType;
import com.efeerturk.enums.CurrencyType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DtoCar extends DtoBase{

	private String plaka;

	private String brand;

	private String model;

	private Integer productionYear;

	private BigDecimal price;

	private CurrencyType currencyType;

	private BigDecimal damagePrice;

	private CarStatusType carStatusType;
}
