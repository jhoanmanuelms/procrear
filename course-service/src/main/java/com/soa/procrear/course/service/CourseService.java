package com.soa.procrear.course.service;

import com.soa.procrear.course.exception.CourseAlreadyExistingException;
import com.soa.procrear.course.exception.CourseNotFoundException;
import com.soa.procrear.course.model.Course;
import com.soa.procrear.course.repository.CourseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course save(Course course) throws CourseAlreadyExistingException {
        if (courseRepository.countByStudentCodeAndSubjectCode(course.getStudentCode(), course.getSubjectCode()) > 0) {
            throw new CourseAlreadyExistingException();
        }

        return courseRepository.save(course);
    }

    public List<Course> getStudentCourses(Integer studentCode) throws CourseNotFoundException {
        List<Course> courses = courseRepository.findByStudentCode(studentCode);

        if (courses.isEmpty()) {
            throw new CourseNotFoundException();
        }

        return courses;
    }

    public Double getGrade(Integer studentCode, String subjectCode) throws CourseNotFoundException {
        return getCourse(studentCode, subjectCode).getGrade();
    }

    public Course setGrade(Integer studentCode, String subjectCode, Double grade) throws CourseNotFoundException {
        Course course = getCourse(studentCode, subjectCode);
        course.setGrade(grade);

        return courseRepository.save(course);
    }

    private Course getCourse(Integer studentCode, String subjectCode) throws CourseNotFoundException {
        Course course = courseRepository.findByStudentCodeAndSubjectCode(studentCode, subjectCode);

        if (course == null) {
            throw new CourseNotFoundException();
        }

        return course;
    }
}
