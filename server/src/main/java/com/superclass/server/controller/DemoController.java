package com.superclass.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping(value="/echo")
    public String echo(@RequestParam(value="request", defaultValue = "Hello World!") String request){
        return request;
    }
}
