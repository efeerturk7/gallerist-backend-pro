package com.efeerturk.gallery_project.mapper;

import com.efeerturk.gallery_project.dto.DtoGalleristCar;
import com.efeerturk.gallery_project.dto.DtoGalleristCarIU;
import com.efeerturk.gallery_project.model.GalleristCar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {IGalleristMapper.class, ICarMapper.class})
public interface IGalleristCarMapper {
    DtoGalleristCar toDto(GalleristCar galleristCar);
    GalleristCar toEntity(DtoGalleristCarIU galleristCarIU);
}
