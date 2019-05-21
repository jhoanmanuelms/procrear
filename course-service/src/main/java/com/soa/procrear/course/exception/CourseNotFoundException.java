package com.soa.procrear.course.exception;

public class CourseNotFoundException extends Exception {
    public CourseNotFoundException() {
        super("Course(s) not found for the student");
    }
}
