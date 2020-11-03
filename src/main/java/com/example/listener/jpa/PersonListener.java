package com.example.listener.jpa;

import com.example.model.Person;
import com.example.service.ListenerService;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

/**
 * @author Gaojx
 */
@Configuration
public class PersonListener {

    private ListenerService listenerService;

    public PersonListener(ListenerService listenerService) {
        this.listenerService = listenerService;
    }

    @PrePersist
    public void prePersist(Person person){
        listenerService.process("prePersist:" + person);
    }

    @PostPersist
    public void postPersist(Person person){
        listenerService.process("postPersist:"+ person);
    }

    @PreRemove
    public void preRemove(Person person){
        listenerService.process("preRemove:" + person);
    }
    @PostRemove
    public void postRemove(Person person){
        listenerService.process("postRemove:" + person);
    }

    @PreUpdate
    public void preUpdate(Person person){
        listenerService.process("preUpdate:" + person);
    }

    @PostUpdate
    public void postUpdate(Person person){
        listenerService.process("postUpdate:" + person);
    }

    @PostLoad
    public void postLoad(Person person){
        listenerService.process("postLoad:" + person);
    }
}
