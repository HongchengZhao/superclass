package com.pomeloish.superclass.service;

import com.pomeloish.superclass.dao.TimeSlotMapper;
import com.pomeloish.superclass.model.TimeSlot;

import java.util.List;

public interface TimeSlotService {
    boolean deleteByPrimaryKey(Integer timeSlotId);
    boolean insert(TimeSlot record);
    boolean updateByPrimaryKey(TimeSlot record);
    TimeSlot selectByPrimaryKey(Integer timeSlotId);
    boolean checkTimeSlot(Integer weekday,Integer startWeek,Integer endWeek,Integer startTime,Integer endTime,Integer weekInterval);
    List<TimeSlot> selectAll();
}
