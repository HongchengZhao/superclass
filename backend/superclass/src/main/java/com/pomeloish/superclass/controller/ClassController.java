package com.pomeloish.superclass.controller;

import com.pomeloish.superclass.model.Class;
import com.pomeloish.superclass.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ClassController {
    @Autowired
    private ClassService classService;

    @RequestMapping(value = "/addClass", method = RequestMethod.POST)
    public boolean addClass(Class record) {
        System.out.println("开始增加...");
        return classService.insert(record);
    }

    @RequestMapping(value = "/updateClass", method = RequestMethod.PUT)
    public boolean updateClass(Class record) {
        System.out.println("开始更新...");
        return classService.updateByPrimaryKey(record);
    }

    @RequestMapping(value = "/deleteClass", method = RequestMethod.DELETE)
    public boolean deleteClass(@RequestParam(value = "classId", required = true) Integer classId,
                               @RequestParam(value = "courseId", required = true) String courseId,
                               @RequestParam(value = "schoolId", required = true) Integer schoolId) {
        System.out.println("开始删除...");
        return classService.deleteByPrimaryKey(classId, courseId, schoolId);
    }

    @RequestMapping(value = "/selectClassByPrimaryKey", method = RequestMethod.GET)
    public Class selectClassByPrimaryKey(@RequestParam(value = "classId", required = true) Integer classId,
                                         @RequestParam(value = "courseId", required = true) String courseId,
                                         @RequestParam(value = "schoolId", required = true) Integer schoolId) {
        System.out.println("开始查询...");
        return classService.selectByPrimaryKey(classId, courseId, schoolId);
    }

    @RequestMapping(value = "/selectClass", method = RequestMethod.GET)
    public List<Class> selectClass() {
        System.out.println("开始查询...");
        return classService.selectAll();
    }
}