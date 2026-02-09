package com.efeerturk.gallery_project.service;

import com.efeerturk.gallery_project.dto.DtoAddress;
import com.efeerturk.gallery_project.dto.DtoAddressIU;
import com.efeerturk.gallery_project.mapper.IAdressMapper;
import com.efeerturk.gallery_project.model.Address;
import com.efeerturk.gallery_project.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final IAdressMapper adressMapper;
    private final AddressRepository addressRepository;


    private Address createAddress(DtoAddressIU dtoAddressIU) {
        Address address=adressMapper.toEntity(dtoAddressIU);
        return address;

    }


    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
        Address savedAddress = addressRepository.save(createAddress(dtoAddressIU));
        DtoAddress dtoAddress=adressMapper.toDto(savedAddress);
        return dtoAddress;
    }
}
