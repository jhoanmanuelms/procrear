package com.soa.procrear.subject.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SubjectExceptionHandler {
    @ExceptionHandler(SubjectNotFoundException.class)
    public ResponseEntity.HeadersBuilder subjectNotFound(SubjectNotFoundException exception) {
        return ResponseEntity.notFound();
    }
}
