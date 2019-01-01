package com.pomeloish.superclass.service;

import com.pomeloish.superclass.model.TimeSlot;
import com.pomeloish.superclass.dao.TimeSlotMapper;
import com.pomeloish.superclass.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlotServiceImpl implements  TimeSlotService{
    @Autowired
    private TimeSlotMapper timeSlotMapper;

    public TimeSlotServiceImpl() {
        super();
    }

    @Override
    public boolean deleteByPrimaryKey(Integer timeSlotId) {
        boolean flag=false;
        try {
            timeSlotMapper.deleteByPrimaryKey(timeSlotId);
            flag=true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean checkTimeSlot(Integer weekday, Integer startWeek, Integer endWeek, Integer startTime, Integer endTime, Integer weekInterval) {
        int num=timeSlotMapper.checkTimeSlot(weekday,startWeek,endWeek,startTime,endTime,weekInterval);
        if (num>0){
            return false;
        }
        else return true;
    }

    @Override
    public boolean insert(TimeSlot record) {
        boolean flag=false;
      //  Integer weekday=record.getWeekday();
      //  Integer startWeek=record.getStartWeek();
      //  Integer endWeek=record.getEndWeek();
     //   Integer startTime=record.getStartTime();
     //   Integer endTime=record.getEndTime();
    //    Integer weekInterval=record.getWeekInterval();
        try {
        //    if(checkTimeSlot(weekday,startWeek,endWeek,startTime,endTime,weekInterval)){
                timeSlotMapper.insert(record);
                flag = true;
         //   }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateByPrimaryKey(TimeSlot record) {
        boolean flag=false;
        try {
            timeSlotMapper.updateByPrimaryKey(record);
            flag=true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public TimeSlot selectByPrimaryKey(Integer timeSlotId) {
        return timeSlotMapper.selectByPrimaryKey(timeSlotId);
    }

    @Override
    public List<TimeSlot> selectAll() {
        return timeSlotMapper.selectAll();
    }
}
