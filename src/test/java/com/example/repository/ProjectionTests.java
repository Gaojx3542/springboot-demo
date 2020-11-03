package com.example.repository;

import com.example.dao.PersonRepository;
import com.example.dto.PersonDto;
import com.example.model.Person;
import com.example.projection.PersonProjectionInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;

/**
 * @author Gaojx
 */
@SpringBootTest
public class ProjectionTests {


    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testProjectionReturn(){
        List<PersonProjectionInterface> people = personRepository.findByNameIs("wyf");
        people.forEach(person -> {
            System.out.println(person.getName());
            System.out.println(person.getAddress());
            System.out.println(person.getAgeDesc());
            System.out.println(person.getCityDesc());
            System.out.println(person.getInfo());
            System.out.println(person.getHello("Hello"));
        });

    }

    @Test
    public void testDtoReturn(){
        List<PersonDto> people = personRepository.findByNameEquals("wyf");
        people.forEach(System.out::println);
    }

    @Test
    public void testDynamicReturn(){
        Collection<Person> people1 = personRepository.findByNameAndAge("wyf", 35, Person.class);
        Collection<PersonProjectionInterface> people2 = personRepository.findByNameAndAge("wyf", 35, PersonProjectionInterface.class);
        Collection<PersonDto> people3 = personRepository.findByNameAndAge("wyf", 35, PersonDto.class);
        people1.forEach(person -> {
            System.out.println(person.getName());
            System.out.println(person.getAddress());
        });
        people2.forEach(personProjectionInterface -> {
            System.out.println(personProjectionInterface.getHello("Hello"));
            System.out.println(personProjectionInterface.getInfo());
        });
        people3.forEach(personDto -> {
            System.out.println(personDto.getName());
            System.out.println(personDto.getAge());
        });
    }

}
