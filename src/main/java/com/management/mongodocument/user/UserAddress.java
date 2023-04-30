package com.management.mongodocument.user;

public class UserAddress {

    private String state;
    private String country;

    public String getState() {
        return state;
    }

    public UserAddress setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserAddress setCountry(String country) {
        this.country = country;
        return this;
    }
}
