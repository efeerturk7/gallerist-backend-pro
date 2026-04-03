package com.efeerturk.gallery_project.service;

import com.efeerturk.gallery_project.dto.DtoCustomer;
import com.efeerturk.gallery_project.dto.DtoCustomerIU;
import com.efeerturk.gallery_project.utils.RestPageableEntity;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);

    RestPageableEntity<DtoCustomer> findAllPageable(Pageable pageable);
}
