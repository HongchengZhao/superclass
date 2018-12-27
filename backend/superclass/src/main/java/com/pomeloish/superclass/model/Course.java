package com.pomeloish.superclass.model;

import java.io.Serializable;

public class Course implements Serializable {
    private String courseId;

    private Integer schoolId;

    private String courseName;

    private String teacherName;

    private static final long serialVersionUID = 1L;
    public Course(String courseId,Integer schoolId,String courseName,String teacherName){
        this.courseId=courseId;
        this.schoolId=schoolId;
        this.courseName=courseName;
        this.teacherName=teacherName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }
}