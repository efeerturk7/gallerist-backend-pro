package com.efeerturk.gallery_project.service;

import com.efeerturk.gallery_project.dto.DtoCar;
import com.efeerturk.gallery_project.dto.DtoCarIU;
import com.efeerturk.gallery_project.utils.RestPageableEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICarService {
    DtoCar saveCar(DtoCarIU dtoCarIU);

    RestPageableEntity<DtoCar> findAllPageable(Pageable pageable);

    List<DtoCar> findByBrand(String brandInput);
}

