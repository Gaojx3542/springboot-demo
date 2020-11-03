package com.example.model;

import com.example.enums.Gender;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by gaojx on 2020/7/15.
 */
@Embeddable
public class Child {

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    public Child(){}

    public Child(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
