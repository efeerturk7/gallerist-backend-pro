package com.efeerturk.gallery_project.service;

import com.efeerturk.gallery_project.dto.DtoGallerist;
import com.efeerturk.gallery_project.dto.DtoGalleristIU;

public interface IGalleristService {
    DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU);
}
