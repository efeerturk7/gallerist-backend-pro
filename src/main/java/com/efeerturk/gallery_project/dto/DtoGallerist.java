package com.efeerturk.gallery_project.dto;

import com.efeerturk.gallery_project.model.BaseEntity;
import lombok.Data;

@Data
public class DtoGallerist extends DtoBase {
    private String firstName;

    private String lastName;

    private DtoAddress address;
}
