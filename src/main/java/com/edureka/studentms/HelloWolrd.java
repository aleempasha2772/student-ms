package com.edureka.studentms;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWolrd {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
