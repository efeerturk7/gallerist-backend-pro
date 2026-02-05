package com.efeerturk.controller.impl;

import com.efeerturk.utils.RestPageableEntity;
import com.efeerturk.utils.RestPageableRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findAll")
	@Override
	public RootEntity<RestPageableEntity<DtoCustomer>> findAllPageable(@Valid @ModelAttribute RestPageableRequest request) {
		return ok(customerService.findAllPageable(toPageable(request)));
	}

}
