package com.example.model;

import com.example.listener.jpa.PersonListener;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by gaojx on 2020/7/14.
 */
@Entity
@Table(name = "t_person", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@EntityListeners({PersonListener.class})
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    private Long id;

    @NotNull
    @Size(min = 3, max = 10)
    @Column(name = "name", length = 10)
    private String name;

    private Integer age;

    private Boolean active = true;

    // 审计功能
    @CreatedDate
    @Column(name = "create_time")
    private LocalDateTime createTime;

    @CreatedBy
    @Column(name = "created_user")
    private String createdUser;

    @LastModifiedDate
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @LastModifiedBy
    @Column(name ="updated_user")
    private String updatedUser;

    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.EAGER)
    private Collection<Child> children;


    public Person(){}

    public Person(String name, Integer age, Address address, Collection<Child> children) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.children = children;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                ", address=" + address +
                ", children=" + children +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Collection<Child> getChildren() {
        return children;
    }

    public void setChildren(Collection<Child> children) {
        this.children = children;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }
}
