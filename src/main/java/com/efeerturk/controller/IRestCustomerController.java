package com.efeerturk.controller;

import com.efeerturk.dto.DtoCustomer;
import com.efeerturk.dto.DtoCustomerIU;

public interface IRestCustomerController {

	public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
}
