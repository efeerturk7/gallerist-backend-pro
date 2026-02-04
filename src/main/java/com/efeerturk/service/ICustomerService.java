package com.efeerturk.service;

import com.efeerturk.dto.DtoCustomer;
import com.efeerturk.dto.DtoCustomerIU;

public interface ICustomerService {

	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}
