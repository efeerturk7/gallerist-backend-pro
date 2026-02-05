package com.efeerturk.controller.impl;

import com.efeerturk.model.Car;
import com.efeerturk.utils.RestPageableEntity;
import com.efeerturk.utils.RestPageableRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.efeerturk.controller.IRestCarController;
import com.efeerturk.controller.RestBaseController;
import com.efeerturk.controller.RootEntity;
import com.efeerturk.dto.DtoCar;
import com.efeerturk.dto.DtoCarIU;
import com.efeerturk.service.ICarService;

import jakarta.validation.Valid;

import java.util.List;

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

	@GetMapping("/findAll")
	@Override
	public RootEntity<RestPageableEntity<DtoCar>> findAllPageable(@Valid @ModelAttribute RestPageableRequest request) {
		return ok(carService.findAllPageable(toPageable(request)));
	}


}
