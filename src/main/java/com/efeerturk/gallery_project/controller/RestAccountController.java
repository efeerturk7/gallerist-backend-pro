package com.efeerturk.gallery_project.controller;

import com.efeerturk.gallery_project.dto.DtoAccount;
import com.efeerturk.gallery_project.dto.DtoAccountIU;
import com.efeerturk.gallery_project.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gallery/account")
@RequiredArgsConstructor
public class RestAccountController extends RestBaseController {

    private final AccountService accountService;

    @PostMapping("/save")
    public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
        return ok(accountService.saveAccount(dtoAccountIU));
    }
}
