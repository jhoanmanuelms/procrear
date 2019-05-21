package com.soa.procrear.student.exception;

public class StudentAlreadyExistingException extends Exception {
    public StudentAlreadyExistingException() {
        super("The student already exists");
    }
}
