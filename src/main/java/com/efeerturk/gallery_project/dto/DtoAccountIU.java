package com.efeerturk.gallery_project.dto;

import com.efeerturk.gallery_project.enums.CurrencyType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class DtoAccountIU {

    @NotBlank
    private String accountNo;

    @NotBlank
    private String iban;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private CurrencyType currencyType;
}
