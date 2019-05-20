package com.soa.procrear.subject.exception;

public class SubjectNotFoundException extends Exception {
    public SubjectNotFoundException() {
        super("Subject not found");
    }
}
