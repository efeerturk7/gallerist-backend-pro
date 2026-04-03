package com.efeerturk.gallery_project.service.impl;

import com.efeerturk.gallery_project.dto.DtoCar;
import com.efeerturk.gallery_project.dto.DtoCarIU;
import com.efeerturk.gallery_project.mapper.ICarMapper;
import com.efeerturk.gallery_project.model.Car;
import com.efeerturk.gallery_project.repository.CarRepository;
import com.efeerturk.gallery_project.service.ICarService;
import com.efeerturk.gallery_project.utils.PagerUtil;
import com.efeerturk.gallery_project.utils.RestPageableEntity;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;


import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarService implements ICarService {
    private final ICarMapper carMapper;
    private final CarRepository carRepository;
    private final RedisService redisService;

    private Car createCar(DtoCarIU dtoCarIU) {
        Car car = carMapper.toEntity(dtoCarIU);
        car.setCreateTime(new Date());
        return car;
    }

    @Override
    public DtoCar saveCar(DtoCarIU dtoCarIU) {
        Car savedCar = carRepository.save(createCar(dtoCarIU));
        String brand= dtoCarIU.getBrand().toUpperCase(Locale.ENGLISH);
        String redisKey="cache::cars::brands::"+brand;
        redisService.deleteValue(redisKey);
        log.info("The cache cleared because appended new data --> {}",redisKey);
        return carMapper.toDto(savedCar);
    }
    @Override
    public RestPageableEntity<DtoCar> findAllPageable(Pageable pageable) {
        String redisKey="cache::cars:page_"+pageable.getPageNumber()
                +"::size_"+pageable.getPageSize()
                +"::sort_"+pageable.getSort().toString().replace(": ","_");
        RestPageableEntity<DtoCar>cachedPage=redisService.getValue(redisKey, new TypeReference<RestPageableEntity<DtoCar>>() {});
        if (cachedPage!=null){
            log.info("REDIS HIT: Page {} retrieved from cache",pageable.getPageNumber());
            return cachedPage;
        }
        log.info("DB MISS: Fetching page {} from the database",pageable.getPageNumber());
        Page<Car> carPage = carRepository.findAllPageable(pageable);
        List<DtoCar> dtoCarList = carPage.getContent().stream()
                .map(carMapper::toDto)
                .toList();
        redisService.setValue(redisKey,dtoCarList,10L);
        log.info("recorded in redis --> {}",pageable.getPageNumber());
        return PagerUtil.toPageableResponse(carPage, dtoCarList);
    }
    @Override
    public List<DtoCar> findByBrand(String brandInput) {
        String brand = brandInput.toUpperCase(Locale.ENGLISH);
        String redisKey = "cache::cars::brands::" + brand;
        List<DtoCar> cachedCars = redisService.getValue(redisKey, new TypeReference<List<DtoCar>>() {
        });
        if (cachedCars != null) {
            log.info("REDIS HIT : Data retrieved from cache (RAM) --> {}", brand);
            return cachedCars;
        } else {
            log.info("DB MISS: going to the database --> {}", brand);
            List<Car> dbCarList = carRepository.findByBrandIgnoreCase(brandInput);
            List<DtoCar> dtoCarList = carMapper.toDtoList(dbCarList);
            redisService.setValue(redisKey,dtoCarList,10L);
            log.info("the data was saved to Redis --> {}",redisKey);
            return dtoCarList;
            }

        }


    }

