package com.soa.procrear.registration.exception;

public class InvalidRegistrationException extends Exception {
    public InvalidRegistrationException() {
        super("Either the student or the subject are invalid");
    }
}
