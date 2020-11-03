package com.example;

import com.example.dao.PersonRepository;
import com.example.dto.PersonDto;
import com.example.enums.Gender;
import com.example.model.Person;
import com.example.projection.PersonProjectionInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
//@EnableTransactionManagement
public class SpringbootDemoApplication {
    private Logger log = LoggerFactory.getLogger(SpringbootDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }


    @Bean
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder){
        // 开启缩进形式
        return builder.indentOutput(true).createXmlMapper(false).build();
    }

    @Bean
    CommandLineRunner reBeanClr(ObjectMapper jacksonObjectMapper){
        return args -> {
          Map map =new HashMap<>();
          map.put("name", "book");
          map.put("price", 119);
          String content = jacksonObjectMapper.writeValueAsString(map);
          System.out.println(content);
        };
    }

    /*@Bean
    CommandLineRunner saveOne(PersonRepository personRepository){
        return args -> {
            Address address = new Address("hefei", "Anhui");
            Collection<Child> children = Arrays.asList(new Child("wyn", Gender.FEMALE), new Child("wbe", Gender.MALE));
            Person person = new Person("wyf1", 35, address, children);
            Person savedPerson = personRepository.save(person);
            log.info(person.toString());
        };
    }*/

   /* @Bean
    CommandLineRunner saveAll(PersonRepository personRepository){
        return args -> {
            Address address1 = new Address("beijing", "Beijing");
            Address address2 = new Address("shanghai", "Shanghai");
            Collection<Child> children1 = Arrays.asList(new Child("aaa", Gender.FEMALE), new Child("bbb", Gender.MALE));
            Collection<Child> children2 = Arrays.asList(new Child("ccc", Gender.FEMALE), new Child("ddd", Gender.MALE));
            Person person1 = new Person("foo", 36, address1, children1);
            Person person2 = new Person("bar", 34, address2, children1);
            List<Person> savedPeople = personRepository.saveAll(Arrays.asList(person1, person2));
            savedPeople.forEach(p ->{
                log.info(p.toString());
            });
        };
    }


    @Bean
    CommandLineRunner delete(PersonRepository personRepository){
        return args -> {
            personRepository.deleteById(1L); //根据id删除
            log.info("-----剩余数量为" + personRepository.count() + "------");
            personRepository.delete(personRepository.getOne(2L)); //根据实体删除
            log.info("-----剩余数量为" + personRepository.count() + "------");
            personRepository.deleteAll(); // 删除所有
            log.info("-----剩余数量为" + personRepository.count() + "------");
        };
    }*/

//    @Bean
//    CommandLineRunner sortQuery(PersonRepository personRepository){
//        return args -> {
//            List<Person> people1 = personRepository.findByAgeLessThan(40, Sort.by("name"));
//            List<Person> people2 = personRepository.findByAgeLessThanWithJqal(40, JpaSort.by(Sort.Direction.DESC, "name"));
//            List<Person> people3 = personRepository.findAll(Sort.by("address.city"));
//            List<Person> people4 = personRepository.findAll(JpaSort.by(Sort.Direction.DESC, "age"));
//            Page<Person> people5 = personRepository.findByAgeLessThan(40, PageRequest.of(0, 2, Sort.by("age")));
//            Page<Person> people6 = personRepository.findAll(PageRequest.of(0, 2, Sort.by("name")));
//
//            people1.forEach(System.out::println);
//            System.out.println("--------------");
//            people2.forEach(System.out::println);
//            System.out.println("--------------");
//            people3.forEach(System.out::println);
//            System.out.println("--------------");
//            people4.forEach(System.out::println);
//            System.out.println("--------------");
//            people5.forEach(System.out::println);
//            System.out.println("--------------");
//            people6.forEach(System.out::println);
//        };
//    }
//
//    @Bean
//    CommandLineRunner testQuery1(PersonRepository personRepository){
//        return args -> {
//            List<Person> people1 = personRepository.findByNameAndAge("wyf", 35);
//            List<Person> people2 = personRepository.findByAddress_City("hefei");
//            List<Person> people3 = personRepository.findByAddressCity("hefei");
//            List<Person> people4 = personRepository.findByCity("hefei");
//            List<Person> people5 = personRepository.findByChildrenGender(Gender.FEMALE);
//            List<Person> people6 = personRepository.findByChildren_Name("wbe");
//
//            people1.forEach(System.out::println);
//            System.out.println("--------------");
//            people2.forEach(System.out::println);
//            System.out.println("--------------");
//            people3.forEach(System.out::println);
//            System.out.println("--------------");
//            people4.forEach(System.out::println);
//            System.out.println("--------------");
//            people5.forEach(System.out::println);
//            System.out.println("--------------");
//            people6.forEach(System.out::println);
//            System.out.println("--------------");
//        };
//    }
//
//    @Bean
//    CommandLineRunner dynamicProjectionQuery(PersonRepository personRepository){
//        return args -> {
//            Collection<Person> people1 = personRepository.findByNameAndAge("wyf", 35, Person.class);
//            Collection<PersonProjectionInterface> people2 = personRepository.findByNameAndAge("wyf", 35, PersonProjectionInterface.class);
//            Collection<PersonDto> people3 = personRepository.findByNameAndAge("wyf", 35, PersonDto.class);
//            people1.forEach(person -> {
//                System.out.println(person.getName());
//                System.out.println(person.getAddress());
//            });
//            people2.forEach(personProjectionInterface -> {
//                System.out.println(personProjectionInterface.getHello("Hello"));
//                System.out.println(personProjectionInterface.getInfo());
//            });
//            people3.forEach(personDto -> {
//                System.out.println(personDto.getName());
//                System.out.println(personDto.getAge());
//            });
//        };
//    }

    /*@Bean
    CommandLineRunner specificationQuery(PersonRepository personRepository){
        return args -> {
            List<Person> people1 = personRepository.findAll(nameEqual("wyf")); //1
            people1.forEach(System.out::println);
            List<Person> people2 = personRepository.findAll(ageLessThanAndNameLike(37,"o"));
            people2.forEach(System.out::println);
            List<Person> people3 = personRepository.findAll(nameEqual("bar").or(ageLessThanAndNameLike(37, "o"))); //2
            people3.forEach(System.out::println);
        };
    }

    @Bean
    CommandLineRunner queryByExample(PersonRepository personRepository){
        return args -> {
            Person person = new Person();
            person.setName("Y"); //1

            ExampleMatcher matcher = ExampleMatcher.matching() //2
                    .withIgnoreCase("name") //3
                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING); //4

            Example<Person> example = Example.of(person, matcher); //5

            List<Person> people = personRepository.findAll(example); //6
            people.forEach(System.out::println);

        };
    }*/
}
