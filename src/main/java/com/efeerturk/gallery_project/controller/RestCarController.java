package com.efeerturk.gallery_project.controller;

import com.efeerturk.gallery_project.dto.DtoCar;
import com.efeerturk.gallery_project.dto.DtoCarIU;
import com.efeerturk.gallery_project.service.CarService;
import com.efeerturk.gallery_project.utils.RestPageableEntity;
import com.efeerturk.gallery_project.utils.RestPageableRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gallery/car")
@RequiredArgsConstructor
public class RestCarController extends RestBaseController {

    private final CarService carService;

    @PostMapping("/save")

    public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
        return ok(carService.saveCar(dtoCarIU));
    }

    @GetMapping("/findAll")
    public RootEntity<RestPageableEntity<DtoCar>> findAllPageable(@Valid @ModelAttribute RestPageableRequest request) {
        return ok(carService.findAllPageable(toPageable(request)));
    }
    @GetMapping("/{brand}")
    public RootEntity<List<DtoCar>>getCars(@PathVariable(name = "brand") String brandInput){
        return RootEntity.ok(carService.findByBrand(brandInput));
    }
}
