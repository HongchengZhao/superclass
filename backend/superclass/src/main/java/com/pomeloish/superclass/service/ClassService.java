package com.pomeloish.superclass.service;

import com.pomeloish.superclass.dao.ClassMapper;
import com.pomeloish.superclass.model.Class;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ClassService {
    boolean deleteByPrimaryKey(@Param("classId") Integer classId, @Param("courseId") String courseId, @Param("schoolId") Integer schoolId);
    boolean insert(Class record);
    boolean updateByPrimaryKey(Class record);
    boolean checkClass(Integer schoolId, String courseId, String classroom, Integer timeSlotId, Byte semester, Date year);
    Class selectByPrimaryKey(@Param("classId") Integer classId, @Param("courseId") String courseId, @Param("schoolId") Integer schoolId);
    List<Class> selectAll();
}
