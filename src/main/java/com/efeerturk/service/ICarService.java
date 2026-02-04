package com.efeerturk.service;

import com.efeerturk.dto.DtoCar;
import com.efeerturk.dto.DtoCarIU;

public interface ICarService {

	public DtoCar saveCar(DtoCarIU dtoCarIU);
}
