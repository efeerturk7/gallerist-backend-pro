package com.efeerturk.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efeerturk.controller.IRestCustomerController;
import com.efeerturk.controller.RestBaseController;
import com.efeerturk.controller.RootEntity;
import com.efeerturk.dto.DtoCustomer;
import com.efeerturk.dto.DtoCustomerIU;
import com.efeerturk.service.ICustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/gallery/customer")
public class RestCustomerControllerImpl extends RestBaseController implements IRestCustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
		return ok(customerService.saveCustomer(dtoCustomerIU));
	}

}
