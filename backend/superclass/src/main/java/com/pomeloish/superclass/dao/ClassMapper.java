package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.Class;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.type.JdbcType;

public interface ClassMapper {
    @Insert({
        "insert into class (school_id, course_id, ",
        "classroom, time_slot_id, ",
        "semester, year)",
        "values (#{schoolId,jdbcType=INTEGER}, #{courseId,jdbcType=VARCHAR}, ",
        "#{classroom,jdbcType=VARCHAR}, #{timeSlotId,jdbcType=INTEGER}, ",
        "#{semester,jdbcType=TINYINT}, #{year,jdbcType=DATE})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="classId", before=false, resultType=Integer.class)
    int insert(Class record);

    @Select({
        "select",
        "class_id, school_id, course_id, classroom, time_slot_id, semester, year",
        "from class"
    })
    @Results({
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER),
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="classroom", property="classroom", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_slot_id", property="timeSlotId", jdbcType=JdbcType.INTEGER),
        @Result(column="semester", property="semester", jdbcType=JdbcType.TINYINT),
        @Result(column="year", property="year", jdbcType=JdbcType.DATE)
    })
    List<Class> selectAll();
}