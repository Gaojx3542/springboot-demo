package com.example.dao;

import com.example.dto.PersonDto;
import com.example.enums.Gender;
import com.example.model.Person;
import com.example.projection.PersonProjectionInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by gaojx on 2020/7/15.
 */
public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

    //JPA命名查询
    // - 根据实体属性名推导查询
    List<Person> findByNameAndAge(String name, Integer age);


    List<Person> findByNameAndAgeAndActiveOrAddress_City(String name, Integer age, Boolean active, String city);


    // - 以值对象的属性作为查询条件
    List<Person> findByAddress_City(String city);
    List<Person> findByAddressCity(String city);
    List<Person> findByChildren_Name(String name);
    List<Person> findByChildrenName(String name);

    List<Person> findByChildrenGender(Gender gender);


    // JPQL查询
    @Query(" select p from Person p where p.address.city = ?1")
    List<Person> findByCity(String city);

//    SQL查询
    @Query(value = "select * from t_person where name = ?1", nativeQuery = true)
    List<Person> findBySql(String name);

//    排序和分页
    List<Person> findByAgeLessThan(Integer age, Sort sort);

    @Query("select p from Person p where p.age < ?1")
    List<Person> findByAgeLessThanWithJqal(Integer age, Sort sort);

    Page<Person> findByAgeLessThan(Integer age, Pageable pageable);

    //命名参数
    @Query("select p from Person p where p.name = :name")
    List<Person> findByJpqlWithNamedParameter(@Param("name") String name);

    //修改查询
    @Transactional
    @Modifying
    @Query("update Person p set p.name = ?1 where p.name =?2")
    int updatePersonName(String newName, String oldName);


    // 定制查询返回Projection：接口或对象
    List<PersonProjectionInterface> findByNameIs(String name);

    List<PersonDto> findByNameEquals(String name);

    <T> Collection<T> findByNameAndAge(String name, Integer age, Class<T> type);


    @Procedure(procedureName = "add_name_prefix") //指定存储过程的名称
    String getPrefixName(String name);


}
