package com.efeerturk.gallery_project.controller;

import com.efeerturk.gallery_project.dto.DtoGallerist;
import com.efeerturk.gallery_project.dto.DtoGalleristIU;
import com.efeerturk.gallery_project.service.GalleristService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gallery/gallerist")
@RequiredArgsConstructor
public class RestGalleristController extends RestBaseController{

    private final GalleristService galleristService;

    @PostMapping("/save")

    public RootEntity<DtoGallerist> saveGallerist(@Valid @RequestBody DtoGalleristIU dtoGalleristIU) {
        return ok(galleristService.saveGallerist(dtoGalleristIU));
    }
}
