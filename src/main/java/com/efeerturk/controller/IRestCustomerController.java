package com.efeerturk.controller;

import com.efeerturk.dto.DtoCustomer;
import com.efeerturk.dto.DtoCustomerIU;
import com.efeerturk.utils.RestPageableEntity;
import com.efeerturk.utils.RestPageableRequest;

public interface IRestCustomerController {

	public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
	public RootEntity<RestPageableEntity<DtoCustomer>>findAllPageable(RestPageableRequest request);
}
