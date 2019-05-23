package com.soa.procrear.certification.dto;

public class StudentDTO {
    private Integer code;
    private String name;

    public StudentDTO(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
