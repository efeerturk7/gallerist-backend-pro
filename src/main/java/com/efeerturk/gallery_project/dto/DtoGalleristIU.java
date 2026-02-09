package com.efeerturk.gallery_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoGalleristIU {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private Long addressId;
}
