package com.superclass.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.superclass.server.service.FetchTimetable;

@RestController
public class DemoController {
    @RequestMapping(value="/echo")
    public String echo(@RequestParam(value="request", defaultValue = "Hello World!") String request){
        return FetchTimetable.homePage("1652738","zhczhc574rinn");
    }
}
