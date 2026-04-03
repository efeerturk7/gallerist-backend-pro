package com.efeerturk.gallery_project.controller;

import com.efeerturk.gallery_project.dto.DtoAddress;
import com.efeerturk.gallery_project.dto.DtoAddressIU;
import com.efeerturk.gallery_project.service.IAddressService;
import com.efeerturk.gallery_project.service.impl.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gallery/address")
@RequiredArgsConstructor
public class RestAddressController extends RestBaseController {

    private final IAddressService addressService;

    @PostMapping("/save")

    public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU dtoAddressIU) {
        return ok(addressService.saveAddress(dtoAddressIU));
    }
}
