package com.efeerturk.gallery_project.mocking;

import com.efeerturk.gallery_project.dto.DtoCustomer;
import com.efeerturk.gallery_project.enums.CurrencyType;
import com.efeerturk.gallery_project.model.Account;
import com.efeerturk.gallery_project.model.Address;
import com.efeerturk.gallery_project.model.Customer;
import com.efeerturk.gallery_project.repository.CustomerRepository;
import com.efeerturk.gallery_project.service.CustomerService;
import com.efeerturk.gallery_project.utils.RestPageableEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void findAllPageable_ShouldMapFullCustomer_WhenAccountAndAddressExist() {

        Pageable pageable = PageRequest.of(0, 5);


        Customer customer = new Customer();
        customer.setFirstName("Efe");

        Account account = new Account();
        account.setCurrencyType(CurrencyType.TL);
        customer.setAccount(account);

        Address address = new Address();
        address.setCity("Istanbul");
        customer.setAddress(address);

        Page<Customer> customerPage = new PageImpl<>(List.of(customer), pageable, 1);


        when(customerRepository.findAllPageable(pageable)).thenReturn(customerPage);


        RestPageableEntity<DtoCustomer> result = customerService.findAllPageable(pageable);


        assertNotNull(result.getContent().get(0).getAccount());
        assertNotNull(result.getContent().get(0).getAddress());
        assertEquals(CurrencyType.TL, result.getContent().get(0).getAccount().getCurrencyType());
    }

    @Test
    void findAllPageable_ShouldNotCrash_WhenAccountAndAddressAreNull() {


        Pageable pageable = PageRequest.of(0, 5);
        Customer customer = new Customer();
        customer.setFirstName("Tired Developer");


        Page<Customer> customerPage = new PageImpl<>(List.of(customer), pageable, 1);
        when(customerRepository.findAllPageable(pageable)).thenReturn(customerPage);


        RestPageableEntity<DtoCustomer> result = customerService.findAllPageable(pageable);


        assertNotNull(result);
        assertNull(result.getContent().get(0).getAccount());
        assertNull(result.getContent().get(0).getAddress());
    }
}
