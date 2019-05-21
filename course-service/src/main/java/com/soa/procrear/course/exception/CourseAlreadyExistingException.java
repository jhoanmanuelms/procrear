package com.soa.procrear.course.exception;

public class CourseAlreadyExistingException extends Exception {
    public CourseAlreadyExistingException() {
        super("The course is already registered for the student");
    }
}
