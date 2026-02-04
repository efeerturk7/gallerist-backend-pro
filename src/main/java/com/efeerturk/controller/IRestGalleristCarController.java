package com.efeerturk.controller;

import com.efeerturk.dto.DtoGalleristCar;
import com.efeerturk.dto.DtoGalleristCarIU;

public interface IRestGalleristCarController {

	public RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
