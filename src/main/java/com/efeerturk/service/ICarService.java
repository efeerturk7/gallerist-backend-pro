package com.efeerturk.service;

import com.efeerturk.dto.DtoCar;
import com.efeerturk.dto.DtoCarIU;
import com.efeerturk.model.Car;
import com.efeerturk.utils.RestPageableEntity;
import org.springframework.data.domain.Pageable;

public interface ICarService {

	public DtoCar saveCar(DtoCarIU dtoCarIU);
	public RestPageableEntity<DtoCar> findAllPageable(Pageable pageable);
}
