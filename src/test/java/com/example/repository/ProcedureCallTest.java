package com.example.repository;

import com.example.dao.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Gaojx
 */
@SpringBootTest
public class ProcedureCallTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void test(){
        String name = personRepository.getPrefixName("haha");
        System.out.println(name);
    }
}
