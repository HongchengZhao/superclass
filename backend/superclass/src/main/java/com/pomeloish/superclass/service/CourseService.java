package com.pomeloish.superclass.service;

import com.pomeloish.superclass.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseService {
    boolean deleteByPrimaryKey(@Param("courseId") String courseId, @Param("schoolId") Integer schoolId);
    boolean insert(Course course);
    boolean updateByPrimaryKey(Course record);
    boolean checkCourse(String courseId,Integer schoolId,String courseName,String teacherName);
    Course selectByPrimaryKey(@Param("courseId") String courseId, @Param("schoolId") Integer schoolId);
    List<Course> selectAll();
}
