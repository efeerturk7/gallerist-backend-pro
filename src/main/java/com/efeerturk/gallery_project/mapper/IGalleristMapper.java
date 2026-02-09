package com.efeerturk.gallery_project.mapper;

import com.efeerturk.gallery_project.dto.DtoGallerist;
import com.efeerturk.gallery_project.dto.DtoGalleristIU;
import com.efeerturk.gallery_project.model.Gallerist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {IAdressMapper.class})
public interface IGalleristMapper {
    DtoGallerist toDto(Gallerist gallerist);
    Gallerist toEntity(DtoGalleristIU galleristIU);
}
