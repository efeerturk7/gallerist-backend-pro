package com.efeerturk.gallery_project.model;

import com.efeerturk.gallery_project.enums.CarStatusType;
import com.efeerturk.gallery_project.enums.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity {
    private String plate;
    private String brand;
    private String model;
    private Integer productionYear;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;
    private BigDecimal damagePrice;
    @Enumerated(EnumType.STRING)
    private CarStatusType carStatusType;
}
