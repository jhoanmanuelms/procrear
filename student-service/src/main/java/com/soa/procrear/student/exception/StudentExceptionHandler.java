package com.soa.procrear.student.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity.HeadersBuilder studentNotFound(StudentNotFoundException exception) {
        return ResponseEntity.notFound();
    }
}
