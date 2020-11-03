package com.example.projection;

import com.example.model.Address;
import org.springframework.beans.factory.annotation.Value;

/**
 * Spring Data JPA查询（定制查询返回Projection：接口或对象）
 * Created by gaojx on 2020/7/16.
 */
public interface PersonProjectionInterface {

    String getName(); //1

    Address getAddress(); //2

    @Value("#{target.name + ' s age is' + target.age}") //3
    String getAgeDesc();

    default String getCityDesc(){ //4
        return getName() + " lives in " + getAddress().getCity();
    }

    @Value("#{@personProjectionHelper.getInfo(target)}") //5
    String getInfo();

    @Value("#{args[0] + ' ' + target.name + ' !'}") //6
    String getHello(String greeting);
}
