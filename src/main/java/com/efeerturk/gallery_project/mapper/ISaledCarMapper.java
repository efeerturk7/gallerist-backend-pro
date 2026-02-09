package com.efeerturk.gallery_project.mapper;

import com.efeerturk.gallery_project.dto.DtoSaledCar;

import com.efeerturk.gallery_project.dto.DtoSaledCarIU;
import com.efeerturk.gallery_project.model.SaledCar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {ICustomerMapper.class,ICarMapper.class, IGalleristMapper.class})
public interface ISaledCarMapper {
    DtoSaledCar toDto(SaledCar saledCar);
    SaledCar toEntity(DtoSaledCarIU saledCarIU);

}
