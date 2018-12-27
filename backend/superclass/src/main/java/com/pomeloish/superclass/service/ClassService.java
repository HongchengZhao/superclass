package com.pomeloish.superclass.service;

import com.pomeloish.superclass.dao.ClassMapper;
import com.pomeloish.superclass.model.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassService {
    boolean deleteByPrimaryKey(@Param("classId") Integer classId, @Param("courseId") String courseId, @Param("schoolId") Integer schoolId);
    boolean insert(Class record);
    boolean updateByPrimaryKey(Class record);
    boolean checkClass();
    Class selectByPrimaryKey(@Param("classId") Integer classId, @Param("courseId") String courseId, @Param("schoolId") Integer schoolId);
    List<Class> selectAll();
}
