package com.efeerturk.controller;

import com.efeerturk.dto.DtoCar;
import com.efeerturk.dto.DtoCarIU;
import com.efeerturk.utils.RestPageableEntity;
import com.efeerturk.utils.RestPageableRequest;
import org.springframework.data.domain.Pageable;

public interface IRestCarController {

	public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);
	public RootEntity<RestPageableEntity<DtoCar>>findAllPageable(RestPageableRequest request);
}
