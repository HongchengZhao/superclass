package com.pomeloish.superclass.service;

import com.pomeloish.superclass.dao.StudentAssignmentMapper;
import com.pomeloish.superclass.dao.TeacherAssignmentMapper;
import com.pomeloish.superclass.model.StudentAssignment;
import com.pomeloish.superclass.model.TeacherAssignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;


@Service
public class AssignmentServiceImpl implements AssignmentService{
    @Autowired
    private TeacherAssignmentMapper teacherAssignmentMapper;
    @Autowired
    private StudentAssignmentMapper studentAssignmentMapper;

    @Override
    public boolean addTeacherAssignment(TeacherAssignment teacherAssignment){
        boolean flag = false;
        try{
            teacherAssignmentMapper.insert(teacherAssignment);
            flag = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteTeacherAssignment(Integer id){
        boolean flag = false;
        try{
            teacherAssignmentMapper.deleteByPrimaryKey(id);
            flag = true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateTeacherAssignment(TeacherAssignment teacherAssignment){
        boolean flag = false;
        try{
            teacherAssignmentMapper.updateByPrimaryKey(teacherAssignment);
            flag = true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;

    }

    @Override
    public StudentAssignment seeStudentAssignment(Integer id){

        try{
            return studentAssignmentMapper.selectByPrimaryKey(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TeacherAssignment seeTeacherAssignment(Integer id){
        try{
            return teacherAssignmentMapper.selectByPrimaryKey(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    //提交作业难以实现
    @Override
    public boolean addStudentAssignment(StudentAssignment studentAssignment){
        boolean flag = false;
        try{
            studentAssignmentMapper.insert(studentAssignment);
            flag = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteStudentAssignment(Integer id){
        boolean flag = false;
        try{
            studentAssignmentMapper.deleteByPrimaryKey(id);
            flag = true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateStudentAssignment(StudentAssignment studentAssignment){
        boolean flag = false;
        try{
            studentAssignmentMapper.updateByPrimaryKey(studentAssignment);
            flag = true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean stopUpload(TeacherAssignment teacherAssignment){
        //怎么知道系统时间
        boolean flag=false;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        try {
            String DATE=df.format(new Date());
            Date dt = df.parse(DATE);
            int i=Integer.parseInt(teacherAssignment.getDeadline());
            if (dt.getTime() > i) {
                flag=true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return flag;
    }

    @Override
    public int countStudent(){
        return studentAssignmentMapper.countStudent();
    }

    //@Override
    //public int showCounts(){
        //和上一个有什么区别
    //}
}
