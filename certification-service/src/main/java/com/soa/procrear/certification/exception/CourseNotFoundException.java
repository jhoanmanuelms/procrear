package com.soa.procrear.certification.exception;

public class CourseNotFoundException extends Exception {
    public CourseNotFoundException() {
        super("The student isn't registered in any course or has an invalid registration");
    }
}
