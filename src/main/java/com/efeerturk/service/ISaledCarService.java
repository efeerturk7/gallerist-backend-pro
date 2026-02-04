package com.efeerturk.service;

import com.efeerturk.dto.DtoSaledCar;
import com.efeerturk.dto.DtoSaledCarIU;

public interface ISaledCarService {

	public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);
}
