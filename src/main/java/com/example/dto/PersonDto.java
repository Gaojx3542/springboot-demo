package com.example.dto;

/**
 * 还可以通过类（DTO：Data Transfer Object 数据传输对象）来定制返回
 * Created by gaojx on 2020/7/16.
 */
public class PersonDto {

    private final String name;
    private final Integer age;

    public PersonDto(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
