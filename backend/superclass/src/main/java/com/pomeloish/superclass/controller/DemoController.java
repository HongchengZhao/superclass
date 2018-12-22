package com.pomeloish.superclass.controller;

import com.pomeloish.superclass.service.FetchTimetable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping(value="/echo")
    public String echo(@RequestParam(value="request", defaultValue = "Hello World!") String request){
        //return FetchTimetable.homePage("1652738","zhczhc574rinn");
        return request;
    }
}
