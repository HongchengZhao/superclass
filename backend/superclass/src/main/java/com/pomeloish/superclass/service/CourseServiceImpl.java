package com.pomeloish.superclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pomeloish.superclass.model.Course;
import com.pomeloish.superclass.dao.CourseMapper;
import com.pomeloish.superclass.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseMapper courseMapper;

    public CourseServiceImpl(){
        super();
    }

    @Override
    public boolean deleteByPrimaryKey(String courseId, Integer schoolId) {
        boolean flag=false;
        try{
            courseMapper.deleteByPrimaryKey(courseId,schoolId);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean checkCourse(String courseId, Integer schoolId, String courseName, String teacherName) {
     int num=courseMapper.checkCourse(courseId,schoolId,courseName,teacherName);
     if(num>0){
         return false;
       }
     else return true;
    }

    @Override
    public boolean insert(Course record){
        boolean flag=false;
        String courseId=record.getCourseId();
        Integer schoolId=record.getSchoolId();
        String courseName=record.getCourseName();
        String teacherName=record.getTeacherName();
        try{
            if(checkCourse(courseId,schoolId,courseName,teacherName))
            {
                courseMapper.insert(record);
                flag=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateByPrimaryKey(Course record) {
        boolean flag=false;
        try{
            courseMapper.updateByPrimaryKey(record);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Course selectByPrimaryKey(String courseId, Integer schoolId) {
        return courseMapper.selectByPrimaryKey(courseId,schoolId);
    }

    @Override
    public List<Course>  selectAll() {
        return courseMapper.selectAll();
    }
}
