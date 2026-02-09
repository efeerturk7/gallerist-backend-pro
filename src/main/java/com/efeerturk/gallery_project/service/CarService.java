package com.efeerturk.gallery_project.service;

import com.efeerturk.gallery_project.dto.DtoCar;
import com.efeerturk.gallery_project.dto.DtoCarIU;
import com.efeerturk.gallery_project.mapper.ICarMapper;
import com.efeerturk.gallery_project.model.Car;
import com.efeerturk.gallery_project.repository.CarRepository;
import com.efeerturk.gallery_project.utils.PagerUtil;
import com.efeerturk.gallery_project.utils.RestPageableEntity;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final ICarMapper carMapper;

    private final CarRepository carRepository;


    private Car createCar(DtoCarIU dtoCarIU) {
        Car car= carMapper.toEntity(dtoCarIU);
        car.setCreateTime(new Date());
        return car;
    }


    public DtoCar saveCar(DtoCarIU dtoCarIU) {
        Car savedCar=carRepository.save(createCar(dtoCarIU));
        return carMapper.toDto(savedCar);
    }

    public RestPageableEntity<DtoCar> findAllPageable(Pageable pageable){
        Page<Car> carPage=carRepository.findAllPageable(pageable);
        List<DtoCar> dtoCarList=carPage.getContent().stream()
                .map(carMapper::toDto)
                .toList();
        return PagerUtil.toPageableResponse(carPage,dtoCarList);
    }
}
