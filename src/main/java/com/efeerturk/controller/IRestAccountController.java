package com.efeerturk.controller;

import com.efeerturk.dto.DtoAccount;
import com.efeerturk.dto.DtoAccountIU;

public interface IRestAccountController {

	public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
}
