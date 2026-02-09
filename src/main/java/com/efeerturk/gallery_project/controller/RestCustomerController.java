package com.efeerturk.gallery_project.controller;

import com.efeerturk.gallery_project.dto.DtoCustomer;
import com.efeerturk.gallery_project.dto.DtoCustomerIU;
import com.efeerturk.gallery_project.service.CustomerService;
import com.efeerturk.gallery_project.utils.RestPageableEntity;
import com.efeerturk.gallery_project.utils.RestPageableRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gallery/customer")
@RequiredArgsConstructor
public class RestCustomerController extends RestBaseController{

    private final CustomerService customerService;

    @PostMapping("/save")

    public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.saveCustomer(dtoCustomerIU));
    }

    @GetMapping("/findAll")

    public RootEntity<RestPageableEntity<DtoCustomer>> findAllPageable(@Valid @ModelAttribute RestPageableRequest request) {
        return ok(customerService.findAllPageable(toPageable(request)));
    }
}
