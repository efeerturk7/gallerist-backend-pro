package com.efeerturk.gallery_project.dto;

import com.efeerturk.gallery_project.enums.CarStatusType;
import com.efeerturk.gallery_project.enums.CurrencyType;
import com.efeerturk.gallery_project.model.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class DtoCar extends DtoBase {
    private String plate;

    private String brand;

    private String model;

    private Integer productionYear;

    private BigDecimal price;

    private CurrencyType currencyType;

    private BigDecimal damagePrice;

    private CarStatusType carStatusType;
}
