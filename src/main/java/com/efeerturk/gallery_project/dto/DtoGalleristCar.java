package com.efeerturk.gallery_project.dto;

import com.efeerturk.gallery_project.model.BaseEntity;
import lombok.Data;

@Data
public class DtoGalleristCar extends DtoBase {
    private DtoGallerist gallerist;

    private DtoCar car;
}
