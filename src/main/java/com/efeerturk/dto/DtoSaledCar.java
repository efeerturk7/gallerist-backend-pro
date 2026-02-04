package com.efeerturk.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DtoSaledCar extends DtoBase{

	private DtoCustomer customer;
	
	private DtoGallerist gallerist;
	
	private DtoCar car;
}
