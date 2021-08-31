package com.imaginist.boot.controller;

import com.imaginist.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Car car;

    @RequestMapping("/car")
    public Car mycar(){
        return car;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Hello, Spring Boot 2!";
    }
}