package com.efeerturk.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DtoGalleristCar extends DtoBase{

	private DtoGallerist gallerist;
	
	private DtoCar car;
}
