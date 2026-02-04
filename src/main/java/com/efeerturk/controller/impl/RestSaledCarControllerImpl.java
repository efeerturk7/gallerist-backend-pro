package com.efeerturk.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efeerturk.controller.IRestSaledCarController;
import com.efeerturk.controller.RestBaseController;
import com.efeerturk.controller.RootEntity;
import com.efeerturk.dto.DtoSaledCar;
import com.efeerturk.dto.DtoSaledCarIU;
import com.efeerturk.service.ISaledCarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/gallery/saled-car")
public class RestSaledCarControllerImpl extends RestBaseController implements IRestSaledCarController{

	@Autowired
	private ISaledCarService saledCarService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoSaledCar> buyCar(@Valid @RequestBody DtoSaledCarIU dtoSaledCarIU) {
		return ok(saledCarService.buyCar(dtoSaledCarIU));
	}

}
