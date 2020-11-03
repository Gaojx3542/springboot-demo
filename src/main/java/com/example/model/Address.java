package com.example.model;

import javax.persistence.Embeddable;

/**
 * Created by gaojx on 2020/7/15.
 */

@Embeddable
public class Address {

    private String city;
    private String province;


    public Address(){}

    public Address(String city, String province) {
        this.city = city;
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
