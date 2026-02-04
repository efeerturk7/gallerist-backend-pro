package com.efeerturk.controller;

import com.efeerturk.dto.DtoSaledCar;
import com.efeerturk.dto.DtoSaledCarIU;

public interface IRestSaledCarController {

	public RootEntity<DtoSaledCar> buyCar(DtoSaledCarIU dtoSaledCarIU);
}
