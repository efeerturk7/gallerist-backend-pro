package com.efeerturk.service;

import com.efeerturk.dto.DtoGalleristCar;
import com.efeerturk.dto.DtoGalleristCarIU;

public interface IGalleristCarService {

	public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
