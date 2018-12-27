package com.pomeloish.superclass.controller;

import com.pomeloish.superclass.model.TimeSlot;
import com.pomeloish.superclass.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class TimeSlotController {
    @Autowired
    private TimeSlotService timeSlotService;

    @RequestMapping(value = "/addTimeSlot", method = RequestMethod.POST)
    public boolean addTimeSlot(TimeSlot record) {
        System.out.println("开始增加...");
        return timeSlotService.insert(record);
    }

    @RequestMapping(value = "/updateTimeSlot", method = RequestMethod.PUT)
    public boolean updateTimeSlot(TimeSlot record) {
        System.out.println("开始更新...");
        return timeSlotService.updateByPrimaryKey(record);
    }

    @RequestMapping(value = "/deleteTimeSlot", method = RequestMethod.DELETE)
    public boolean deleteTimeSlot(@RequestParam(value = "timeSlotId", required = true) Integer timeSlotId) {
        System.out.println("开始删除...");
        return timeSlotService.deleteByPrimaryKey(timeSlotId);
    }

    @RequestMapping(value = "/selectTimeSlotByPrimaryKey", method = RequestMethod.GET)
    public TimeSlot selectClassByPrimaryKey(@RequestParam(value = "timlSlotId", required = true) Integer timeSlotId) {
        System.out.println("开始查询...");
        return timeSlotService.selectByPrimaryKey(timeSlotId);
    }

    @RequestMapping(value = "/selectTimeSlot", method = RequestMethod.GET)
    public List<TimeSlot> selectTimeSlot() {
        System.out.println("开始查询...");
        return timeSlotService.selectAll();
    }
}