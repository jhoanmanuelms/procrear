package com.soa.procrear.registration.dto;

public class StudentDTO {
    private Integer code;

    private String name;

    private String lastName;

    private Integer availableCredits;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAvailableCredits() {
        return availableCredits;
    }

    public void setAvailableCredits(Integer availableCredits) {
        this.availableCredits = availableCredits;
    }
}
