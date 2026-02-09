package com.efeerturk.gallery_project.mapper;

import com.efeerturk.gallery_project.dto.DtoCar;
import com.efeerturk.gallery_project.dto.DtoCarIU;
import com.efeerturk.gallery_project.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICarMapper {
    DtoCar toDto(Car car);
    Car toEntity(DtoCarIU carIU);
}
