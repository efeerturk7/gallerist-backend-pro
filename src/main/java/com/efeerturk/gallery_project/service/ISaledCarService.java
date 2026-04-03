package com.efeerturk.gallery_project.service;

import com.efeerturk.gallery_project.dto.DtoSaledCar;
import com.efeerturk.gallery_project.dto.DtoSaledCarIU;
import com.efeerturk.gallery_project.model.Car;
import com.efeerturk.gallery_project.model.Customer;
import com.efeerturk.gallery_project.utils.RestPageableEntity;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface ISaledCarService {
    BigDecimal convertCustomerAmountToUSD(Customer customer);

    boolean checkCarStatus(Long carId);

    BigDecimal remaningCustomerAmount(Customer customer, Car car);

    boolean checkAmount(DtoSaledCarIU dtoSaledCarIU);

    DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);

    RestPageableEntity<DtoSaledCar> findAllPageable(Pageable pageable);
}
