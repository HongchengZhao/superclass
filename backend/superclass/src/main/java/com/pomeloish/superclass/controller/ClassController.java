package com.pomeloish.superclass.controller;

import com.pomeloish.superclass.model.Class;
import com.pomeloish.superclass.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "api/classe")
public class ClassController {
    @Autowired
    private ClassService classService;

    @PostMapping
    public boolean insertClass(@RequestBody Class class1) {
        return classService.insert(class1);
    }

    @GetMapping(value = "/{classId}/{courseId}/{schoolId}")
    public Class selectByPrimaryKey(@PathVariable("classId") Integer classId,
                                    @PathVariable("courseId") String courseId,
                                    @PathVariable("schoolId") Integer schoolId){
        return classService.selectByPrimaryKey(classId,courseId,schoolId);
    }

}