package com.soa.procrear.certification.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.service-inventory")
public class CompositionConfig {
    private String averageService;
    private String courseService;
    private String printService;
    private String subjectService;
    private String studentService;

    public String getAverageService() {
        return averageService;
    }

    public void setAverageService(String averageService) {
        this.averageService = averageService;
    }

    public String getCourseService() {
        return courseService;
    }

    public void setCourseService(String courseService) {
        this.courseService = courseService;
    }

    public String getPrintService() {
        return printService;
    }

    public void setPrintService(String printService) {
        this.printService = printService;
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
