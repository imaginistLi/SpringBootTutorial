package com.imaginist.boot05web01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/bug.jpg")
    public String hello(){
        return "hahaha";
    }
}
