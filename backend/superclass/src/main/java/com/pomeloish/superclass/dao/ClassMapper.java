package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.Class;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface ClassMapper {
    @Select({
            "select count(*)",
            "from class",
            "where course_id = #{courseId,jdbcType=VARCHAR}",
            "and school_id = #{schoolId,jdbcType=INTEGER}",
            "and classroom=#{classroom,jdbcType=VARCHAR}",
            "and time_slot_id=#{timeSlotId,jdbcType=INTEGER}",
            "and semester=#{semester,jdbcType=TINYINT}",
            "and year=#{year,jdbcType=DATE}"
    })
    int checkClass(Integer schoolId, String courseId, String classroom, Integer timeSlotId, Byte semester, Date year);
    @Delete({
            "delete from class",
            "where class_id = #{classId,jdbcType=INTEGER}",
            "and course_id = #{courseId,jdbcType=VARCHAR}",
            "and school_id = #{schoolId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(@Param("classId") Integer classId, @Param("courseId") String courseId, @Param("schoolId") Integer schoolId);
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
            "class_id, course_id, school_id, classroom, time_slot_id, semester, year",
            "from class",
            "where class_id = #{classId,jdbcType=INTEGER}",
            "and course_id = #{courseId,jdbcType=VARCHAR}",
            "and school_id = #{schoolId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="course_id", property="courseId", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="classroom", property="classroom", jdbcType=JdbcType.VARCHAR),
            @Result(column="time_slot_id", property="timeSlotId", jdbcType=JdbcType.INTEGER),
            @Result(column="semester", property="semester", jdbcType=JdbcType.TINYINT),
            @Result(column="year", property="year", jdbcType=JdbcType.DATE)
    })
    Class selectByPrimaryKey(@Param("classId") Integer classId, @Param("courseId") String courseId, @Param("schoolId") Integer schoolId);
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
    @Update({
            "update class",
            "set classroom = #{classroom,jdbcType=VARCHAR},",
            "time_slot_id = #{timeSlotId,jdbcType=INTEGER},",
            "semester = #{semester,jdbcType=TINYINT},",
            "year = #{year,jdbcType=DATE}",
            "where class_id = #{classId,jdbcType=INTEGER}",
            "and course_id = #{courseId,jdbcType=INTEGER}",
            "and school_id = #{schoolId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Class record);
}