package com.soa.procrear.registration.exception;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RegistrationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InvalidRegistrationException.class)
    public void invalidRegistration(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(NotEnoughCreditsException.class)
    public void notEnoughCredits(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.PRECONDITION_FAILED.value());
    }

    @ExceptionHandler(StudentAlreadyRegisteredException.class)
    public void studentAlreadyRegistered(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.CONFLICT.value());
    }
}
