package com.pomeloish.superclass.model;

import java.io.Serializable;

public class TimeSlot implements Serializable {
    private Integer timeSlotId;

    private Integer weekday;

    private Integer startWeek;

    private Integer endWeek;

    private Integer startTime;

    private Integer endTime;

    private Integer weekInterval;

    private static final long serialVersionUID = 1L;

    public Integer getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(Integer timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Integer getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(Integer startWeek) {
        this.startWeek = startWeek;
    }

    public Integer getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(Integer endWeek) {
        this.endWeek = endWeek;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getWeekInterval() {
        return weekInterval;
    }

    public void setWeekInterval(Integer weekInterval) {
        this.weekInterval = weekInterval;
    }
}