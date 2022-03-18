package com.react.portfolio_project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
