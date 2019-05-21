package com.soa.procrear.course.controller;

import com.soa.procrear.course.exception.CourseAlreadyExistingException;
import com.soa.procrear.course.exception.CourseNotFoundException;
import com.soa.procrear.course.model.Course;
import com.soa.procrear.course.service.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseResource {
    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public Course register(@RequestBody Course course) throws CourseAlreadyExistingException {
        return courseService.save(course);
    }

    @GetMapping("/course/student/{studentCode}")
    public List<Course> getStudentCourses(@PathVariable Integer studentCode) throws CourseNotFoundException {
        return courseService.getStudentCourses(studentCode);
    }

    @GetMapping("/course/grades/student/{studentCode}/subject/{subjectCode}")
    public Double getStudentGrade(@PathVariable Integer studentCode, @PathVariable String subjectCode)
    throws CourseNotFoundException {
        return courseService.getGrade(studentCode, subjectCode);
    }

    @PutMapping("/course/grades/student/{studentCode}/subject/{subjectCode}")
    public Course setStudentGrade(
        @PathVariable Integer studentCode, @PathVariable String subjectCode, @RequestParam Double grade)
    throws CourseNotFoundException {
        return courseService.setGrade(studentCode, subjectCode, grade);
    }
}
