package com.efeerturk.gallery_project.service;



import com.efeerturk.gallery_project.dto.DtoCustomer;
import com.efeerturk.gallery_project.dto.DtoCustomerIU;
import com.efeerturk.gallery_project.enums.MessageType;
import com.efeerturk.gallery_project.exception.BaseException;
import com.efeerturk.gallery_project.exception.ErrorMessage;
import com.efeerturk.gallery_project.mapper.ICustomerMapper;
import com.efeerturk.gallery_project.model.Account;
import com.efeerturk.gallery_project.model.Address;
import com.efeerturk.gallery_project.model.Customer;
import com.efeerturk.gallery_project.repository.AccountRepository;
import com.efeerturk.gallery_project.repository.AddressRepository;
import com.efeerturk.gallery_project.repository.CustomerRepository;
import com.efeerturk.gallery_project.utils.PagerUtil;
import com.efeerturk.gallery_project.utils.RestPageableEntity;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final ICustomerMapper customerMapper;

    private final CustomerRepository customerRepository;


    private final AddressRepository addressRepository;


    private final AccountRepository accountRepository;

    private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
        Optional<Address> optAddress = addressRepository.findById(dtoCustomerIU.getAddressId());
        if(optAddress.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAddressId().toString()));
        }

        Optional<Account> optAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
        if(optAccount.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAccountId().toString()));
        }


        Customer customer = customerMapper.toEntity(dtoCustomerIU);
        customer.setCreateTime(new Date());
        customer.setAddress(optAddress.get());
        customer.setAccount(optAccount.get());
        return customer;
    }


    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
       Customer savedCustomer=customerRepository.save(createCustomer(dtoCustomerIU));
       return customerMapper.toDto(savedCustomer);
    }


    public RestPageableEntity<DtoCustomer> findAllPageable(Pageable pageable) {
        Page<Customer> customerPage=customerRepository.findAllPageable(pageable);
        List<DtoCustomer> dtoCustomerList=customerPage.getContent()
                .stream().map(customerMapper::toDto).toList();
        return PagerUtil.toPageableResponse(customerPage,dtoCustomerList);
    }
}
