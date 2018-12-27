package com.pomeloish.superclass.controller;

import com.pomeloish.superclass.model.Course;
import com.pomeloish.superclass.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public boolean addCourse(Course record) {
        System.out.println("开始增加...");
        return courseService.insert(record);
    }

    @RequestMapping(value = "/updateCourse", method = RequestMethod.PUT)
    public boolean updateCourse(Course record) {
        System.out.println("开始更新...");
        return courseService.updateByPrimaryKey(record);
    }

    @RequestMapping(value = "/deleteCourse", method = RequestMethod.DELETE)
    public boolean deleteCourse(@RequestParam(value = "courseId", required = true) String courseId,
                                @RequestParam(value = "schoolId", required = true) Integer schoolId) {
        System.out.println("开始删除...");
        return courseService.deleteByPrimaryKey(courseId,schoolId);
    }

    @RequestMapping(value = "/selectCourseByPrimaryKey", method = RequestMethod.GET)
    public Course selectCourseByPrimaryKey(@RequestParam(value = "courseId", required = true) String courseId,
                                           @RequestParam(value = "schoolId", required = true) Integer schoolId) {
        System.out.println("开始查询...");
        return courseService.selectByPrimaryKey(courseId,schoolId);
    }

    @RequestMapping(value = "/selectCourse", method = RequestMethod.GET)
    public List<Course> selectCourse() {
        System.out.println("开始查询...");
        return courseService.selectAll();
    }
}
