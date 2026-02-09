package com.efeerturk.gallery_project.controller;

import com.efeerturk.gallery_project.dto.CurrencyRatesResponse;
import com.efeerturk.gallery_project.service.CurrencyRatesService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gallery/gallerist")
@RequiredArgsConstructor
public class RestCurrencyRatesController extends RestBaseController {

    private final CurrencyRatesService currencyRatesService;

    @GetMapping("/currency-rates")

    public RootEntity<CurrencyRatesResponse> getCurrencyRates(
            @RequestParam("startDate") String startDate, @RequestParam("startDate") String endDate) {
        return ok(currencyRatesService.getCurrencyRates(startDate, endDate));
    }

}
