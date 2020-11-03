package com.example.service;

import org.springframework.stereotype.Service;

/**
 * @author Gaojx
 */
@Service
public class ListenerService {
    public void process(String msg){
        System.out.println("由Spring处理：" + msg);
    }
}
