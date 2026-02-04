package com.efeerturk.service;

import com.efeerturk.dto.DtoAccount;
import com.efeerturk.dto.DtoAccountIU;

public interface IAccountService {

	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
