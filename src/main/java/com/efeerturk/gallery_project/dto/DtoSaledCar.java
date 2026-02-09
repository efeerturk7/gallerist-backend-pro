package com.efeerturk.gallery_project.dto;

import com.efeerturk.gallery_project.model.BaseEntity;
import lombok.Data;

@Data
public class DtoSaledCar extends BaseEntity {
    private DtoCustomer customer;

    private DtoGallerist gallerist;

    private DtoCar car;
}
