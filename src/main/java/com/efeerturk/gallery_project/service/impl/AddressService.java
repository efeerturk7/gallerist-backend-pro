package com.efeerturk.gallery_project.service.impl;

import com.efeerturk.gallery_project.dto.DtoAddress;
import com.efeerturk.gallery_project.dto.DtoAddressIU;
import com.efeerturk.gallery_project.mapper.IAdressMapper;
import com.efeerturk.gallery_project.model.Address;
import com.efeerturk.gallery_project.repository.AddressRepository;
import com.efeerturk.gallery_project.service.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService implements IAddressService {
    private final IAdressMapper adressMapper;
    private final AddressRepository addressRepository;

    @Override
     public Address createAddress(DtoAddressIU dtoAddressIU) {
        Address address=adressMapper.toEntity(dtoAddressIU);
        return address;

    }

    @Override
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
        Address savedAddress = addressRepository.save(createAddress(dtoAddressIU));
        DtoAddress dtoAddress=adressMapper.toDto(savedAddress);
        return dtoAddress;
    }
}
