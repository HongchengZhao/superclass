package com.pomeloish.superclass.controller;


import com.pomeloish.superclass.service.FetchTimetable;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {
    @RequestMapping(value="/echo")
    public String echo(@RequestParam(value="request", defaultValue = "Hello World!") String request){
        return FetchTimetable.homePage("1652738","zhczhc574rinn");
    }
}
