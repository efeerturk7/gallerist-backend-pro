package com.efeerturk.gallery_project.dto;

import com.efeerturk.gallery_project.model.BaseEntity;
import lombok.Data;

@Data
public class DtoAddress extends BaseEntity {
    private String city;

    private String district;

    private String neighborhood;

    private String street;
}
