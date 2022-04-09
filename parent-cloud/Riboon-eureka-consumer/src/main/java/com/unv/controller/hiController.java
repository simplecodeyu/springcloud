package com.unv.controller;

import com.unv.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hiController {
    @Autowired
    RibbonService ribbonService;

    @GetMapping("/hi")
    public String hi(String name){
        return ribbonService.hi(name);
    }
}
