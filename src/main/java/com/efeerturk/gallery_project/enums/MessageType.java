package com.efeerturk.gallery_project.enums;

import lombok.Getter;

@Getter
public enum MessageType {
    NO_RECORD_EXIST("1004" , "no record found"),
    TOKEN_IS_EXPIRED("1005" , "token expired"),
    USERNAME_NOT_FOUND("1006" , "username not found"),
    USERNAME_OR_PASSWORD_INVALID("1007" , "username or password is incorrect"),
    REFRESH_TOKEN_NOT_FOUND("1008" , "refresh token not found"),
    REFRESH_TOKEN_IS_EXPIRED("1009" , "refresh token expired"),
    CURRENY_RATES_IS_OCCURED("1010" , "Could not get exchange rate"),
    CUSTOMER_AMOUNT_IS_NOT_ENOUGH("1011" , "The customer doesn't have enough money."),
    CAR_STATUS_IS_ALREADY_SALED("1012" , "The car appears to be sold, so it cannot be sold."),
    GENERAL_EXCEPTION("9999" , "A general error occurred");

    private String code;
    private String message;

    MessageType(String code , String message) {
        this.code =code;
        this.message = message;
    }
}
