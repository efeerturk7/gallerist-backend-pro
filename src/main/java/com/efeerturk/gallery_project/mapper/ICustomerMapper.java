package com.efeerturk.gallery_project.mapper;

import com.efeerturk.gallery_project.dto.DtoCustomer;
import com.efeerturk.gallery_project.dto.DtoCustomerIU;
import com.efeerturk.gallery_project.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {IAccountMapper.class, IAdressMapper.class})
public interface ICustomerMapper {
    DtoCustomer toDto(Customer customer);
    Customer toEntity(DtoCustomerIU customerIU);
}
