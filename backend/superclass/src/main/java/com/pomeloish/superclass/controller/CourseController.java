package com.pomeloish.superclass.controller;

import com.pomeloish.superclass.model.Course;
import com.pomeloish.superclass.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public boolean insertCourse(@RequestBody Course course) {
        return courseService.insert(course);
    }

    @GetMapping(value = "/{courseId}/{schoolId}")
    public Course selectByPrimaryKey(@PathVariable("courseId") String courseId,
                                      @PathVariable("schoolId") Integer schoolId) {
        return courseService.selectByPrimaryKey(courseId,schoolId);
    }

}
