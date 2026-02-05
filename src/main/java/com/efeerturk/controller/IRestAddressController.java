package com.efeerturk.controller;

import com.efeerturk.dto.DtoAddress;
import com.efeerturk.dto.DtoAddressIU;
import com.efeerturk.utils.RestPageableRequest;

public interface IRestAddressController {

	public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);

}
