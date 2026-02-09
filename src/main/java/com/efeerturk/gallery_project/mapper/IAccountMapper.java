package com.efeerturk.gallery_project.mapper;

import com.efeerturk.gallery_project.dto.DtoAccount;
import com.efeerturk.gallery_project.dto.DtoAccountIU;
import com.efeerturk.gallery_project.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAccountMapper {
    DtoAccount toDto(Account account);
    Account toEntity(DtoAccountIU accountIU);


}
