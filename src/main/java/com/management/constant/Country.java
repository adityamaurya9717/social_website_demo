package com.management.constant;

public enum Country {

    INDIA(91,"India"),
    PAKISTAN(92,"Pakistan"),
    NEPAL(34,"Nepal");

    int countryCode;
    String countryName;
    Country(int countryCode,String countryName){
        this.countryCode = countryCode;
        this.countryName = countryName;
    }



}
