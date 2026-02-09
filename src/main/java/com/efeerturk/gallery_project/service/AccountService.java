package com.efeerturk.gallery_project.service;

import com.efeerturk.gallery_project.dto.DtoAccount;
import com.efeerturk.gallery_project.dto.DtoAccountIU;
import com.efeerturk.gallery_project.mapper.IAccountMapper;
import com.efeerturk.gallery_project.model.Account;
import com.efeerturk.gallery_project.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Date;
@Service
@RequiredArgsConstructor
public class AccountService {
    private final IAccountMapper accountMapper;
    private final AccountRepository accountRepository;


    private Account createAccount(DtoAccountIU dtoAccountIU) {
        return accountMapper.toEntity(dtoAccountIU);

    }
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {

        Account savedAccount=accountRepository.save(createAccount(dtoAccountIU));
        return accountMapper.toDto(savedAccount);

    }
}
