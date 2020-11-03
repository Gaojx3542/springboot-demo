package com.example.specification;

import com.example.model.Person;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

/**
 * 定义Specification来定制查询，我们需要Repository继承JpaSpecificationExecutor接口
 * root：要查询的实体；
 * query：用来进行高级别的查询，如where、select方法等；
 * criteriaBuilder：用来构造查询，可使用如like、equal、lessThan等，返回值为Predicate；
 * javax.persistence.criteria.Predicate：用来作为查询的条件，可组合。
 *
 * Created by gaojx on 2020/7/16.
 */
public class CustomSpecs {
    public static Specification<Person> nameEqual(String name){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name); //1
    }

    public static Specification<Person> ageLessThanAndNameLike(Integer age, String name){
        return (root, query, criteriaBuilder) -> {
            Predicate ageLessThanPredicate = criteriaBuilder.lessThan(root.get("age"), age); //2
            Predicate nameLikePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%"); //3
            query.where(ageLessThanPredicate, nameLikePredicate); //4
            return query.getRestriction(); //5
        };
    }
}
