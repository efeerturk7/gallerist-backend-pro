package com.efeerturk.gallery_project.service;

import com.efeerturk.gallery_project.dto.DtoGalleristCar;
import com.efeerturk.gallery_project.dto.DtoGalleristCarIU;

public interface IGalleristCarService {
    DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
