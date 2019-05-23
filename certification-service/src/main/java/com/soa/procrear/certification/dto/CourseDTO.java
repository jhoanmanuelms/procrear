package com.soa.procrear.certification.dto;

public class CourseDTO {
    private String code;
    private String name;
    private Double grade;

    public CourseDTO(String code, String name, Double grade) {
        this.code = code;
        this.name = name;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Double getGrade() {
        return grade;
    }
}
