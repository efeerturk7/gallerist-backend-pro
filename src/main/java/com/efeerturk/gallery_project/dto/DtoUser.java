package com.efeerturk.gallery_project.dto;

import com.efeerturk.gallery_project.model.BaseEntity;
import lombok.Data;

@Data
public class DtoUser extends DtoBase {
    private String username;

    private String password;
}
