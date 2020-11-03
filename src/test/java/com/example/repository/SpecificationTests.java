package com.example.repository;

import com.example.dao.PersonRepository;
import com.example.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.specification.CustomSpecs.ageLessThanAndNameLike;
import static com.example.specification.CustomSpecs.nameEqual;

/**
 * @author Gaojx
 */
@SpringBootTest
public class SpecificationTests {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void test(){
        List<Person> people1 = personRepository.findAll(nameEqual("wyf")); //1
        people1.forEach(System.out::println);
        List<Person> people2 = personRepository.findAll(ageLessThanAndNameLike(37,"o"));
        people2.forEach(System.out::println);
        List<Person> people3 = personRepository.findAll(nameEqual("bar").or(ageLessThanAndNameLike(37, "o"))); //2
        people3.forEach(System.out::println);
    }

}
