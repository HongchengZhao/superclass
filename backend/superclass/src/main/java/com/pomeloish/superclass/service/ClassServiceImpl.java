package com.pomeloish.superclass.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pomeloish.superclass.model.Class;
import com.pomeloish.superclass.dao.ClassMapper;
import com.pomeloish.superclass.service.ClassService;

import java.util.Date;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    public ClassServiceImpl(){
        super();
    }

    @Override
    public boolean deleteByPrimaryKey(Integer classId, String courseId, Integer schoolId) {
        boolean flag=false;
        try {
            classMapper.deleteByPrimaryKey(classId,courseId,schoolId);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
//需在数据库中查询对应的TimeSlotId与CourseId，符合的再存入Class数据库中
    @Override
    public boolean checkClass(Integer schoolId, String courseId, String classroom, Integer timeSlotId, Byte semester, Date year) {
        int num=classMapper.checkClass(schoolId,courseId,classroom,timeSlotId,semester,year);
        if(num>0){
            return false;
        }
        else return true;
    }

    @Override
    public boolean insert(Class record) {
        boolean flag=false;
    //    String courseId=record.getCourseId();
    //    Integer schoolId=record.getSchoolId();
    //    String classroom=record.getClassroom();
    //    Integer timeSlotId=record.getTimeSlotId();
     //   Byte semester=record.getSemester();
    //    Date year=record.getYear();
        try {
        //    if (checkClass(schoolId,courseId,classrm,timeSlotId,semester,year))
            classMapper.insert(record);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateByPrimaryKey(Class record) {
        boolean flag=false;
        try {
            classMapper.updateByPrimaryKey(record);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Class selectByPrimaryKey(Integer classId, String courseId, Integer schoolId) {
        return classMapper.selectByPrimaryKey(classId,courseId,schoolId);
    }

    @Override
    public List<Class> selectAll() {
        return classMapper.selectAll();
    }
}
