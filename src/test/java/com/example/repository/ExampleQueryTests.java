package com.example.repository;

import com.example.dao.PersonRepository;
import com.example.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import java.util.List;

/**
 * Qurery by Example简称QBE，它会根据部分属性已经设置的实体，动态进行查询。它主要分为3个部分：
 *
 * Probe：设置属性的实体；
 * ExampleMatcher：对于实体的属性的匹配规则的设置；
 * Example :组合Probe和ExampleMatcher进行查询
 *
 * @author Gaojx
 */
@SpringBootTest
public class ExampleQueryTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void test(){

        Person person = new Person();
        person.setName("Y"); //1

        ExampleMatcher matcher = ExampleMatcher.matching() //2
                .withIgnoreCase("name") //3
                .withStringMatcher(StringMatcher.CONTAINING); //4

        Example<Person> example = Example.of(person, matcher); //5

        List<Person> people = personRepository.findAll(example); //6
        people.forEach(System.out::println);
    }
}
