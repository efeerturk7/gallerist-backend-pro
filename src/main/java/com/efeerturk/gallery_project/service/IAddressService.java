package com.efeerturk.gallery_project.service;

import com.efeerturk.gallery_project.dto.DtoAddress;
import com.efeerturk.gallery_project.dto.DtoAddressIU;
import com.efeerturk.gallery_project.model.Address;

public interface IAddressService {
    Address createAddress(DtoAddressIU dtoAddressIU);

    DtoAddress saveAddress(DtoAddressIU dtoAddressIU);
}

