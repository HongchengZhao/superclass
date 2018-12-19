package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.Class;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ClassMapper {
    @Delete({
        "delete from superclass..class",
        "where class_id = #{classId,jdbcType=INTEGER}",
          "and course_id = #{courseId,jdbcType=INTEGER}",
          "and school_id = #{schoolId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(@Param("classId") Integer classId, @Param("courseId") Integer courseId, @Param("schoolId") Integer schoolId);

    @Insert({
        "insert into superclass..class (class_id, course_id, ",
        "school_id, classroom, ",
        "time_slot_id, semester, ",
        "year)",
        "values (#{classId,jdbcType=INTEGER}, #{courseId,jdbcType=INTEGER}, ",
        "#{schoolId,jdbcType=INTEGER}, #{classroom,jdbcType=VARCHAR}, ",
        "#{timeSlotId,jdbcType=INTEGER}, #{semester,jdbcType=TINYINT}, ",
        "#{year,jdbcType=DATE})"
    })
    int insert(Class record);

    @Select({
        "select",
        "class_id, course_id, school_id, classroom, time_slot_id, semester, year",
        "from superclass..class",
        "where class_id = #{classId,jdbcType=INTEGER}",
          "and course_id = #{courseId,jdbcType=INTEGER}",
          "and school_id = #{schoolId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="classroom", property="classroom", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_slot_id", property="timeSlotId", jdbcType=JdbcType.INTEGER),
        @Result(column="semester", property="semester", jdbcType=JdbcType.TINYINT),
        @Result(column="year", property="year", jdbcType=JdbcType.DATE)
    })
    Class selectByPrimaryKey(@Param("classId") Integer classId, @Param("courseId") Integer courseId, @Param("schoolId") Integer schoolId);

    @Select({
        "select",
        "class_id, course_id, school_id, classroom, time_slot_id, semester, year",
        "from superclass..class"
    })
    @Results({
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="classroom", property="classroom", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_slot_id", property="timeSlotId", jdbcType=JdbcType.INTEGER),
        @Result(column="semester", property="semester", jdbcType=JdbcType.TINYINT),
        @Result(column="year", property="year", jdbcType=JdbcType.DATE)
    })
    List<Class> selectAll();

    @Update({
        "update superclass..class",
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