package com.pomeloish.superclass.service;

import com.pomeloish.superclass.model.StudentAssignment;
import com.pomeloish.superclass.model.TeacherAssignment;

public interface AssignmentService {
    boolean addTeacherAssignment(TeacherAssignment teacherAssignment);

    boolean deleteTeacherAssignment(Integer id);

    boolean updateTeacherAssignment(TeacherAssignment teacherAssignment);

    StudentAssignment seeStudentAssignment(Integer id);

    TeacherAssignment seeTeacherAssignment(Integer id);

    boolean addStudentAssignment(StudentAssignment studentAssignment);

    boolean deleteStudentAssignment(Integer id);

    boolean updateStudentAssignment(StudentAssignment studentAssignment);

    boolean stopUpload(TeacherAssignment teacherAssignment);

    int countStudent();

    //int showCounts();


}
