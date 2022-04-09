package com.unv.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Value("${server.port}")
    Integer port;

    @GetMapping("/hi")
    public String hi(String name){
        return "hi "+name+",port:"+port;
    }
}
