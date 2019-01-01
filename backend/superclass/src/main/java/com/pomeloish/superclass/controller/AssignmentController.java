package com.pomeloish.superclass.controller;


import com.pomeloish.superclass.model.TeacherAssignment;
import com.pomeloish.superclass.model.StudentAssignment;
import com.pomeloish.superclass.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/assignments")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/addTeacherAssignment")
    public boolean addTeacherAssignment(@RequestBody TeacherAssignment teacherAssignment){
        return assignmentService.addTeacherAssignment(teacherAssignment);
    }

    @DeleteMapping("/deleteTeacherAssignment/{id}")
    public boolean deleteTeacherAssignment(@PathVariable("id") Integer id){
        return assignmentService.deleteTeacherAssignment(id);
    }

    @PutMapping("/updateTeacherAssignment")
    public boolean updateTeacherAssignment(@RequestBody TeacherAssignment teacherAssignment){
        return assignmentService.updateTeacherAssignment(teacherAssignment);
    }

    @GetMapping(value="/seeStudentAssignment/{id}")
    public StudentAssignment seeStudentAssignment(@PathVariable("id") Integer id){
        return assignmentService.seeStudentAssignment(id);
    }

    @GetMapping(value = "/seeTeacherAssignment/{id}")
    public TeacherAssignment seeTeacherAssignment(@PathVariable("id") Integer id){
        return assignmentService.seeTeacherAssignment(id);
    }


    @PostMapping("/addStudentAssignment")
    public boolean addStudentAssignment(@RequestBody StudentAssignment  studentAssignment){
        return assignmentService.addStudentAssignment(studentAssignment);
    }

    @DeleteMapping("/deleteStudentAssignment/{id}")
    public boolean deleteStudentAssignment(@PathVariable ("id") Integer id){
        return assignmentService.deleteStudentAssignment(id);
    }

    @PutMapping("/updateStudentAssignment")
    public boolean updateStudentAssignment(@RequestBody StudentAssignment studentAssignment){
        return assignmentService.updateStudentAssignment(studentAssignment);
    }

    @PostMapping
    public int countStudent(){
        return assignmentService.countStudent();
    }

}
