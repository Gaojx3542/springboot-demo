package com.example.helper;

import com.example.model.Person;
import org.springframework.stereotype.Component;

/**
 * Created by gaojx on 2020/7/16.
 */
@Component
public class PersonProjectionHelper {

    public String getInfo(Person person){
        return person.toString();
    }
}
