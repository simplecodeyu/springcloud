package com.unv.controller;

import com.unv.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SayHiController {
    @Autowired
    private HiService hiService;
    @GetMapping("/sayHi")
    public String sayHi(String name){
        return hiService.sayHi(name);
    }
}
