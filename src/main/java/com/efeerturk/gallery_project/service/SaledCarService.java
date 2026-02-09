package com.efeerturk.gallery_project.service;

import com.efeerturk.gallery_project.dto.*;
import com.efeerturk.gallery_project.enums.CarStatusType;
import com.efeerturk.gallery_project.enums.MessageType;
import com.efeerturk.gallery_project.exception.BaseException;
import com.efeerturk.gallery_project.exception.ErrorMessage;
import com.efeerturk.gallery_project.mapper.ISaledCarMapper;
import com.efeerturk.gallery_project.model.Car;
import com.efeerturk.gallery_project.model.Customer;
import com.efeerturk.gallery_project.model.SaledCar;
import com.efeerturk.gallery_project.repository.CarRepository;
import com.efeerturk.gallery_project.repository.CustomerRepository;
import com.efeerturk.gallery_project.repository.SaledCarRepository;
import com.efeerturk.gallery_project.utils.PagerUtil;
import com.efeerturk.gallery_project.utils.RestPageableEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaledCarService {
    private final ISaledCarMapper saledCarMapper;
    private final SaledCarRepository saledCarRepository;
    private final CustomerRepository customerRepository;
    private CarRepository carRepository;
    private CurrencyRatesService currencyRatesService;


    public BigDecimal convertCustomerAmountToUSD(Customer customer) {

        CurrencyRatesResponse currencyRatesResponse = currencyRatesService
                .getCurrencyRates("04-02-2026", "04-02-2026");
        BigDecimal usd = new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd());

        BigDecimal customerUSDAmount = customer.getAccount().getAmount().divide(usd, 2, RoundingMode.HALF_UP);

        return customerUSDAmount;
    }

    public boolean checkCarStatus(Long carId) {
        Optional<Car> optCar = carRepository.findById(carId);
        if (optCar.isPresent() && optCar.get().getCarStatusType().name().equals(CarStatusType.SALED.name())) {
            return false;
        }
        return true;
    }

    public BigDecimal remaningCustomerAmount(Customer customer, Car car) {
        BigDecimal customerUSDAmount = convertCustomerAmountToUSD(customer);
        BigDecimal remaningCustomerUSDAmount = customerUSDAmount.subtract(car.getPrice());

        CurrencyRatesResponse currencyRatesResponse = currencyRatesService.getCurrencyRates("04-02-2026", "04-02-2026");
        BigDecimal usd = new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd());


        return remaningCustomerUSDAmount.multiply(usd);
    }

    public boolean checkAmount(DtoSaledCarIU dtoSaledCarIU) {

        Optional<Customer> optCustomer = customerRepository.findById(dtoSaledCarIU.getCustomerId());
        if (optCustomer.isEmpty()) {
            throw new BaseException(
                    new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoSaledCarIU.getCustomerId().toString()));
        }

        Optional<Car> optCar = carRepository.findById(dtoSaledCarIU.getCarId());
        if (optCar.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoSaledCarIU.getCarId().toString()));
        }

        BigDecimal customerUSDAmount = convertCustomerAmountToUSD(optCustomer.get());

        if (customerUSDAmount.compareTo(optCar.get().getPrice()) == 0
                || customerUSDAmount.compareTo(optCar.get().getPrice()) > 0) {
            return true;
        }
        return false;

    }

    private SaledCar createSaledCar(DtoSaledCarIU dtoSaledCarIU) {
        SaledCar saledCar= saledCarMapper.toEntity(dtoSaledCarIU);
        SaledCar savedSaledCar=saledCarRepository.save(saledCar);
        return savedSaledCar;
    }


    public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU) {

        if (!checkCarStatus(dtoSaledCarIU.getCarId())) {
            throw new BaseException(new ErrorMessage(MessageType.CAR_STATUS_IS_ALREADY_SALED, dtoSaledCarIU.getCarId().toString()));
        }

        if (!checkAmount(dtoSaledCarIU)) {
            throw new BaseException(new ErrorMessage(MessageType.CUSTOMER_AMOUNT_IS_NOT_ENOUGH, ""));
        }

        SaledCar savedSaledCar = saledCarRepository.save(createSaledCar(dtoSaledCarIU));

        Car car = savedSaledCar.getCar();
        car.setCarStatusType(CarStatusType.SALED);
        carRepository.save(car);

        Customer customer = savedSaledCar.getCustomer();
        customer.getAccount().setAmount(remaningCustomerAmount(customer, car));
        customerRepository.save(customer);

        return saledCarMapper.toDto(savedSaledCar);
    }


    public RestPageableEntity<DtoSaledCar> findAllPageable(Pageable pageable) {
        Page<SaledCar> saledCarPage = saledCarRepository.findAllPageable(pageable);
        List<DtoSaledCar>dtoSaledCarList=saledCarPage.getContent().stream()
                .map(saledCarMapper ::toDto)
                .collect(Collectors.toList());
        return PagerUtil.toPageableResponse(saledCarPage,dtoSaledCarList);

    }




}
