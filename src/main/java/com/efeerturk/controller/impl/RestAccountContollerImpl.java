package com.efeerturk.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efeerturk.controller.IRestAccountController;
import com.efeerturk.controller.RestBaseController;
import com.efeerturk.controller.RootEntity;
import com.efeerturk.dto.DtoAccount;
import com.efeerturk.dto.DtoAccountIU;
import com.efeerturk.service.IAccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/gallery/account")
public class RestAccountContollerImpl extends RestBaseController implements IRestAccountController {

	@Autowired
	private IAccountService accountService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
		return ok(accountService.saveAccount(dtoAccountIU));
	}

}
