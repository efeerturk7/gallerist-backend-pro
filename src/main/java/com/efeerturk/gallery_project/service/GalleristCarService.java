package com.efeerturk.gallery_project.service;

import com.efeerturk.gallery_project.dto.*;
import com.efeerturk.gallery_project.enums.MessageType;
import com.efeerturk.gallery_project.exception.BaseException;
import com.efeerturk.gallery_project.exception.ErrorMessage;
import com.efeerturk.gallery_project.mapper.IGalleristCarMapper;
import com.efeerturk.gallery_project.model.Car;
import com.efeerturk.gallery_project.model.Gallerist;
import com.efeerturk.gallery_project.model.GalleristCar;
import com.efeerturk.gallery_project.repository.CarRepository;
import com.efeerturk.gallery_project.repository.GalleristCarRepository;
import com.efeerturk.gallery_project.repository.GalleristRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GalleristCarService {
    private final IGalleristCarMapper galleristCarMapper;
    private final GalleristCarRepository galleristCarRepository;
    private final GalleristRepository galleristRepository;
    private final CarRepository carRepository;

    private GalleristCar createGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {

        Optional<Gallerist> optGallerist = galleristRepository.findById(dtoGalleristCarIU.getGalleristId());
        if(optGallerist.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristCarIU.getGalleristId().toString()));
        }

        Optional<Car> optCar = carRepository.findById(dtoGalleristCarIU.getCarId());
        if(optCar.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristCarIU.getCarId().toString()));
        }


        GalleristCar galleristCar = galleristCarMapper.toEntity(dtoGalleristCarIU);
        galleristCar.setCreateTime(new Date());
        galleristCar.setGallerist(optGallerist.get());
        galleristCar.setCar(optCar.get());

        return galleristCar;

    }


    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
        GalleristCar savedGalleristCar=galleristCarRepository.save(createGalleristCar(dtoGalleristCarIU));
        return galleristCarMapper.toDto(savedGalleristCar);
    }
}
