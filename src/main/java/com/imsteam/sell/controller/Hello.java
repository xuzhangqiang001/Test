package com.imsteam.sell.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping("/hello")
    public String hello(String strHello){
        strHello = "Hello Dandan11";
        return  strHello;
    }
}
