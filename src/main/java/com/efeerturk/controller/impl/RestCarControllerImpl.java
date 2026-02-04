package com.efeerturk.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efeerturk.controller.IRestCarController;
import com.efeerturk.controller.RestBaseController;
import com.efeerturk.controller.RootEntity;
import com.efeerturk.dto.DtoCar;
import com.efeerturk.dto.DtoCarIU;
import com.efeerturk.service.ICarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/gallery/car")
public class RestCarControllerImpl extends RestBaseController implements IRestCarController{

	@Autowired
	private ICarService carService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
		return ok(carService.saveCar(dtoCarIU));
	}

}
