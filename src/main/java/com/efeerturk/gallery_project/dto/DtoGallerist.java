package com.efeerturk.gallery_project.dto;

import com.efeerturk.gallery_project.model.BaseEntity;
import lombok.Data;

@Data
public class DtoGallerist extends BaseEntity {
    private String firstName;

    private String lastName;

    private DtoAddress address;
}
