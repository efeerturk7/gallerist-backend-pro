package com.efeerturk.service;

import com.efeerturk.dto.DtoCar;
import com.efeerturk.dto.DtoCustomer;
import com.efeerturk.dto.DtoCustomerIU;
import com.efeerturk.utils.RestPageableEntity;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
	public RestPageableEntity<DtoCustomer>findAllPageable(Pageable pageable);
}
