package com.efeerturk.gallery_project.mapper;

import com.efeerturk.gallery_project.dto.DtoAddress;
import com.efeerturk.gallery_project.dto.DtoAddressIU;
import com.efeerturk.gallery_project.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAdressMapper {
    DtoAddress toDto(Address address);
    Address toEntity(DtoAddressIU addressIU);
}
