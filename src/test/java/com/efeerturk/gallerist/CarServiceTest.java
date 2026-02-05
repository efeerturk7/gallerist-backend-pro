package com.efeerturk.gallerist;

import com.efeerturk.dto.DtoCar;
import com.efeerturk.model.Car;
import com.efeerturk.repository.CarRepository;
import com.efeerturk.service.impl.CarServiceImpl;
import com.efeerturk.utils.RestPageableEntity;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;
    @Test
    void findAllPageable_ShouldReturnRestPageableEntity_WhenCarsExist() {
        Pageable pageable = PageRequest.of(0, 5);
        Car car = new Car();
        car.setId(1L);
        car.setBrand("BMW");
        List<Car> carList = List.of(car);
        Page<Car> carPage = new PageImpl<>(carList, pageable, 1);
        when(carRepository.findAllPageable(pageable)).thenReturn(carPage);
        RestPageableEntity<DtoCar> result = carService.findAllPageable(pageable);
        assertNotNull(result);
        assertEquals(1, result.getContent().size());
        assertEquals(1, result.getTotalElements());
        verify(carRepository, times(1)).findAllPageable(pageable);
    }
}
