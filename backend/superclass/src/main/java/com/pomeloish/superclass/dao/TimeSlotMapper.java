package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.TimeSlot;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface TimeSlotMapper {
    @Select({
            "select count(*)",
            "from superclass..time_slot",
            "where weekday=#{weekday,jdbcType=INTEGER}",
            "and start_week = #{startWeek,jdbcType=INTEGER}",
            "and end_week = #{endWeek,jdbcType=INTEGER}",
            "and start_time = #{startTime,jdbcType=INTEGER}",
            "and end_time = #{endTime,jdbcType=INTEGER}",
            "and week_interval = #{weekInterval,jdbcType=INTEGER}"
    })
    int checkTimeSlot(Integer weekday,Integer startWeek,Integer endWeek,Integer startTime,Integer endTime,Integer weekInterval);

    @Delete({
        "delete from superclass..time_slot",
        "where time_slot_id = #{timeSlotId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer timeSlotId);

    @Insert({
        "insert into superclass..time_slot (time_slot_id, weekday, ",
        "start_week, end_week, ",
        "start_time, end_time, ",
        "week_interval)",
        "values (#{timeSlotId,jdbcType=INTEGER}, #{weekday,jdbcType=INTEGER}, ",
        "#{startWeek,jdbcType=INTEGER}, #{endWeek,jdbcType=INTEGER}, ",
        "#{startTime,jdbcType=INTEGER}, #{endTime,jdbcType=INTEGER}, ",
        "#{weekInterval,jdbcType=INTEGER})"
    })
    int insert(TimeSlot record);

    @Select({
        "select",
        "time_slot_id, weekday, start_week, end_week, start_time, end_time, week_interval",
        "from superclass..time_slot",
        "where time_slot_id = #{timeSlotId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="time_slot_id", property="timeSlotId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="weekday", property="weekday", jdbcType=JdbcType.INTEGER),
        @Result(column="start_week", property="startWeek", jdbcType=JdbcType.INTEGER),
        @Result(column="end_week", property="endWeek", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.INTEGER),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.INTEGER),
        @Result(column="week_interval", property="weekInterval", jdbcType=JdbcType.INTEGER)
    })
    TimeSlot selectByPrimaryKey(Integer timeSlotId);

    @Select({
        "select",
        "time_slot_id, weekday, start_week, end_week, start_time, end_time, week_interval",
        "from superclass..time_slot"
    })
    @Results({
        @Result(column="time_slot_id", property="timeSlotId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="weekday", property="weekday", jdbcType=JdbcType.INTEGER),
        @Result(column="start_week", property="startWeek", jdbcType=JdbcType.INTEGER),
        @Result(column="end_week", property="endWeek", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.INTEGER),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.INTEGER),
        @Result(column="week_interval", property="weekInterval", jdbcType=JdbcType.INTEGER)
    })
    List<TimeSlot> selectAll();

    @Update({
        "update superclass..time_slot",
        "set weekday = #{weekday,jdbcType=INTEGER},",
          "start_week = #{startWeek,jdbcType=INTEGER},",
          "end_week = #{endWeek,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=INTEGER},",
          "end_time = #{endTime,jdbcType=INTEGER},",
          "week_interval = #{weekInterval,jdbcType=INTEGER}",
        "where time_slot_id = #{timeSlotId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TimeSlot record);
}