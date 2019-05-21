package com.soa.procrear.student.exception;

public class NotEnoughCreditsException extends Exception {
    public NotEnoughCreditsException() {
        super("The student doesn't have enough credits");
    }
}
