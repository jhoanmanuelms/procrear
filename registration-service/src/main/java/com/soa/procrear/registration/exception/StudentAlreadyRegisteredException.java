package com.soa.procrear.registration.exception;

public class StudentAlreadyRegisteredException extends Exception {
    public StudentAlreadyRegisteredException() {
        super("The student is already registered in the course");
    }
}
