package com.soa.procrear.certification.dto;

import java.util.List;

public class CertificationDTO {
    private StudentDTO student;
    private List<CourseDTO> courses;
    private String average;

    public CertificationDTO(StudentDTO student, List<CourseDTO> courses, String average) {
        this.student = student;
        this.courses = courses;
        this.average = average;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public String getAverage() {
        return average;
    }
}
