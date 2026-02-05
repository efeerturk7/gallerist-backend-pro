package com.efeerturk.service;

import com.efeerturk.dto.DtoSaledCar;
import com.efeerturk.dto.DtoSaledCarIU;
import com.efeerturk.utils.RestPageableEntity;
import org.springframework.data.domain.Pageable;

public interface ISaledCarService {

	public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);

}
