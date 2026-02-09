package com.efeerturk.gallery_project.utils;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RestPageableRequest {
    @NotNull
    private int pageNumber;
    @NotNull
    private int pageSize;
    @NotBlank
    private String columnName;
    private boolean asc;
}
