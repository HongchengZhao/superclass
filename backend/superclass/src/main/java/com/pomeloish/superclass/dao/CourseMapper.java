package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.Course;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.type.JdbcType;

public interface CourseMapper {
    @Insert({
        "insert into course (school_id, course_name, ",
        "teacher_name)",
        "values (#{schoolId,jdbcType=INTEGER}, #{courseName,jdbcType=VARCHAR}, ",
        "#{teacherName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="courseId", before=false, resultType=String.class)
    int insert(Course record);

    @Select({
        "select",
        "course_id, school_id, course_name, teacher_name",
        "from course"
    })
    @Results({
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_name", property="teacherName", jdbcType=JdbcType.VARCHAR)
    })
    List<Course> selectAll();
}