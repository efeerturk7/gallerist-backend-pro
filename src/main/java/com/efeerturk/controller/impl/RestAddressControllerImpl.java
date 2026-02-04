package com.efeerturk.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efeerturk.controller.IRestAddressController;
import com.efeerturk.controller.RestBaseController;
import com.efeerturk.controller.RootEntity;
import com.efeerturk.dto.DtoAddress;
import com.efeerturk.dto.DtoAddressIU;
import com.efeerturk.service.IAddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/gallery/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController{

	@Autowired
	private IAddressService addressService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU dtoAddressIU) {
		return ok(addressService.saveAddress(dtoAddressIU));
	}

}
