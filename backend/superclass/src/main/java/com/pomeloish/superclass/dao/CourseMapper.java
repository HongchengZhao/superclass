package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.Course;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface CourseMapper {
@Select({
        "select count(*)",
        "from course",
        "where course_id = #{courseId,jdbcType=VARCHAR}",
        "and school_id = #{schoolId,jdbcType=INTEGER}",
        "and course_name=#{courseName,jdbcType=VARCHAR}",
        "and teacher_name=#{teacherName,jdbcType=VARCHAR}"
})
int checkCourse(String courseId,Integer schoolId,String courseName,String teacherName);
    @Delete({
            "delete from course",
            "where course_id = #{courseId,jdbcType=VARCHAR}",
            "and school_id = #{schoolId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(@Param("courseId") String courseId, @Param("schoolId") Integer schoolId);
    @Select({
            "select",
            "course_id, school_id, course_name, teacher_name",
            "from course",
            "where course_id = #{courseId,jdbcType=VARCHAR}",
            "and school_id = #{schoolId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="course_id", property="courseId", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR),
            @Result(column="teacher_name", property="teacherName", jdbcType=JdbcType.VARCHAR)
    })
    Course selectByPrimaryKey(@Param("courseId") String courseId, @Param("schoolId") Integer schoolId);
    @Insert({
        "insert into course (course_id,school_id, course_name, ",
        "teacher_name)",
        "values (#{courseId,jdbcType=INTEGER},#{schoolId,jdbcType=INTEGER}, #{courseName,jdbcType=VARCHAR}, ",
        "#{teacherName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="courseId", before=false, resultType=String.class)
    int insert(Course course);

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
    @Update({
            "update course",
            "set course_name = #{courseName,jdbcType=VARCHAR},",
            "teacher_name = #{teacherName,jdbcType=VARCHAR}",
            "where course_id = #{courseId,jdbcType=INTEGER}",
            "and school_id = #{schoolId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Course record);
}