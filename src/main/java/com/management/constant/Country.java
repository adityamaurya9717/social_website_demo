package com.management.constant;

public enum Country {

    INDIA(91,"India");

    int countryCode;
    String countryName;
    Country(int countryCode,String countryName){
        this.countryCode = countryCode;
        this.countryName = countryName;
    }


}
