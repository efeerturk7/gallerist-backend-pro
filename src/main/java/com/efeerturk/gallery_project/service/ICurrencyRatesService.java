package com.efeerturk.gallery_project.service;

import com.efeerturk.gallery_project.dto.CurrencyRatesResponse;

public interface ICurrencyRatesService {
    CurrencyRatesResponse getCurrencyRates(String startDate, String endDate);
}

