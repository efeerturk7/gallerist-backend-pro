package com.efeerturk.gallery_project.service;

import com.efeerturk.gallery_project.dto.DtoAccount;
import com.efeerturk.gallery_project.dto.DtoAccountIU;
import com.efeerturk.gallery_project.model.Account;

public interface IAccountService {
    Account createAccount(DtoAccountIU dtoAccountIU);

    DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
