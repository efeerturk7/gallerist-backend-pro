package com.efeerturk.gallery_project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DtoAddressIU {
    @NotBlank
    private String city;

    @NotBlank
    private String district;

    @NotBlank
    private String neighborhood;

    @NotBlank
    private String street;
}
