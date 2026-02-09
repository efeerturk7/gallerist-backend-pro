package com.efeerturk.gallery_project.controller;

import com.efeerturk.gallery_project.dto.DtoGalleristCar;
import com.efeerturk.gallery_project.dto.DtoGalleristCarIU;
import com.efeerturk.gallery_project.service.GalleristCarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gallery/gallerist-car")
@RequiredArgsConstructor
public class RestGalleristCarController extends RestBaseController {

    private final GalleristCarService galleristCarService;

    @PostMapping("/save")

    public RootEntity<DtoGalleristCar> saveGalleristCar(@Valid @RequestBody DtoGalleristCarIU dtoGalleristCarIU) {
        return ok(galleristCarService.saveGalleristCar(dtoGalleristCarIU));
    }
}
