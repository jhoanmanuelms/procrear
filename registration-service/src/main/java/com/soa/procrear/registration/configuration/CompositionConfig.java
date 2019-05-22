package com.soa.procrear.registration.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.service-inventory")
public class CompositionConfig {
    private String courseService;
    private String subjectService;
    private String studentService;

    public String getCourseService() {
        return courseService;
    }

    public void setCourseService(String courseService) {
        this.courseService = courseService;
    }

    public String getSubjectService() {
        return subjectService;
    }

    public void setSubjectService(String subjectService) {
        this.subjectService = subjectService;
    }

    public String getStudentService() {
        return studentService;
    }

    public void setStudentService(String studentService) {
        this.studentService = studentService;
    }
}
