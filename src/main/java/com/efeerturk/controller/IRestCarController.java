package com.efeerturk.controller;

import com.efeerturk.dto.DtoCar;
import com.efeerturk.dto.DtoCarIU;

public interface IRestCarController {

	public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);
}
