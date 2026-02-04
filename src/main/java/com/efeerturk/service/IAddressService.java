package com.efeerturk.service;

import com.efeerturk.dto.DtoAddress;
import com.efeerturk.dto.DtoAddressIU;

public interface IAddressService {

	public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);
}
