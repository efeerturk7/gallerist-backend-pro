package com.efeerturk.gallery_project.mocking;

import com.efeerturk.gallery_project.model.Customer;
import com.efeerturk.gallery_project.model.Gallerist;
import com.efeerturk.gallery_project.model.SaledCar;
import com.efeerturk.gallery_project.repository.SaledCarRepository;
import com.efeerturk.gallery_project.service.SaledCarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
@ExtendWith(MockitoExtension.class)
public class SaledCarServiceTest {
    @Mock
    private SaledCarRepository saledCarRepository;
    @InjectMocks
    private SaledCarService saledCarService;
    @Test
    void findAllPageable(){
        Pageable pageable= PageRequest.of(0,1);
        SaledCar saledCar=new SaledCar();
        Customer customer=new Customer();
        Gallerist gallerist=new Gallerist();
        gallerist.setFirstName("Jack");
        customer.setFirstName("Maliy");
        saledCar.setId(1L);
        saledCar.setCustomer(customer);
        saledCar.setGallerist(gallerist);
        List<SaledCar> saledCarList = List.of(saledCar);
        Page<SaledCar> pageEntity = new PageImpl<>(saledCarList);
        Mockito.when(saledCarRepository.findAllPageable(pageable)).thenReturn(pageEntity);
        var result = saledCarService.findAllPageable(pageable);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getContent().size());
        Mockito.verify(saledCarRepository).findAllPageable(pageable);

    }
}
