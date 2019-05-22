package com.soa.procrear.registration.exception;

public class NotEnoughCreditsException extends Exception {
    public NotEnoughCreditsException() {
        super("The student doesn't have the required credits");
    }
}
