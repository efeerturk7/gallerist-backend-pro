package com.efeerturk.gallery_project.controller;

import com.efeerturk.gallery_project.dto.DtoSaledCar;
import com.efeerturk.gallery_project.dto.DtoSaledCarIU;
import com.efeerturk.gallery_project.service.SaledCarService;
import com.efeerturk.gallery_project.utils.RestPageableEntity;
import com.efeerturk.gallery_project.utils.RestPageableRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gallery/saled-car")
@RequiredArgsConstructor
public class RestSaledCarController extends RestBaseController {

    private final SaledCarService saledCarService;

    @PostMapping("/save")
    public RootEntity<DtoSaledCar> buyCar(@Valid @RequestBody DtoSaledCarIU dtoSaledCarIU) {
        return ok(saledCarService.buyCar(dtoSaledCarIU));
    }
    @GetMapping("/findAll")
    public RootEntity<RestPageableEntity<DtoSaledCar>> findAllPageable(@Valid @ModelAttribute RestPageableRequest request) {
        return ok(saledCarService.findAllPageable(toPageable(request)));
    }

}
