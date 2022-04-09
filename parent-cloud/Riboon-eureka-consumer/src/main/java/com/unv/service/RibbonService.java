package com.unv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    public String hi(String name){
        return restTemplate.getForObject("http://EUREKA-CLIENT-DEMO/hi?name="+name,String.class);
    }
}
