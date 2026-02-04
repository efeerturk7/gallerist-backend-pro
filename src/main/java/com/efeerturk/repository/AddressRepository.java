package com.efeerturk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efeerturk.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
