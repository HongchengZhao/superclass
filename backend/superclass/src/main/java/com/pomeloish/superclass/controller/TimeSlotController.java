package com.pomeloish.superclass.controller;

import com.pomeloish.superclass.model.TimeSlot;
import com.pomeloish.superclass.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "api/TimeSlot")
public class TimeSlotController {
    @Autowired
    private TimeSlotService timeSlotService;

    @PostMapping
    public boolean insertTimeSlot(@RequestBody TimeSlot timeSlot) {
        return timeSlotService.insert(timeSlot);
    }

    @GetMapping(value = "/{timeSlotId}")
    public TimeSlot selectByPrimaryKey(@PathVariable("timeSlotId") Integer timeSlotId) {
        return timeSlotService.selectByPrimaryKey(timeSlotId);
    }
}