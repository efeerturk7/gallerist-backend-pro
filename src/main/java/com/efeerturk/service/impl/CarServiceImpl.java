package com.efeerturk.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efeerturk.dto.DtoCar;
import com.efeerturk.dto.DtoCarIU;
import com.efeerturk.model.Car;
import com.efeerturk.repository.CarRepository;
import com.efeerturk.service.ICarService;

@Service
public class CarServiceImpl implements ICarService{
	
	@Autowired
	private CarRepository carRepository;

	
	private Car createCar(DtoCarIU dtoCarIU) {
		Car car = new Car();
		car.setCreateTime(new Date());
		
		BeanUtils.copyProperties(dtoCarIU, car);
		return car;
	}
	
	@Override
	public DtoCar saveCar(DtoCarIU dtoCarIU) {
		DtoCar dtoCar = new DtoCar();
		Car savedCar =  carRepository.save(createCar(dtoCarIU));
		
		BeanUtils.copyProperties(savedCar, dtoCar);
		return dtoCar;
	}

	
}
