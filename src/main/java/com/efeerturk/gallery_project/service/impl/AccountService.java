package com.efeerturk.gallery_project.service.impl;

import com.efeerturk.gallery_project.dto.DtoAccount;
import com.efeerturk.gallery_project.dto.DtoAccountIU;
import com.efeerturk.gallery_project.mapper.IAccountMapper;
import com.efeerturk.gallery_project.model.Account;
import com.efeerturk.gallery_project.repository.AccountRepository;
import com.efeerturk.gallery_project.service.IAccountService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {
    private final IAccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    public Account createAccount(DtoAccountIU dtoAccountIU) {
        return accountMapper.toEntity(dtoAccountIU);
    }

    @Override
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
        Account savedAccount=accountRepository.save(createAccount(dtoAccountIU));
        return accountMapper.toDto(savedAccount);
    }
}
