package com.efeerturk.gallery_project.dto;

import com.efeerturk.gallery_project.enums.CurrencyType;
import com.efeerturk.gallery_project.model.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class DtoAccount extends DtoBase {
    private String accountNo;

    private String iban;

    private BigDecimal amount;

    private CurrencyType currencyType;
}
