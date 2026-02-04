package com.efeerturk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efeerturk.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
