package com.example.repository;

import com.example.dao.PersonRepository;
import com.example.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Gaojx
 */
@SpringBootTest
public class PersonRepositoryTests {


    @Autowired
    private PersonRepository personRepository;

    @Test
    public void findPerson(){
        List<Person> personList = personRepository.findByNameAndAgeAndActiveOrAddress_City("1",1 ,true, "1");
        System.out.println(personList.size());
    }

}
