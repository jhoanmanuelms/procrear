package com.soa.procrear.student.controller;

import com.soa.procrear.student.exception.NotEnoughCreditsException;
import com.soa.procrear.student.exception.StudentNotFoundException;
import com.soa.procrear.student.model.Student;
import com.soa.procrear.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResource {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{code}")
    public Student getStudentByCode(@PathVariable Integer code) throws StudentNotFoundException {
        // TODO move the exception to the service
        return studentService.getStudentByCode(code).orElseThrow(StudentNotFoundException::new);
    }

    @GetMapping("/student/{code}/credits")
    public Integer getStudentCredits(@PathVariable Integer code) throws StudentNotFoundException {
        Student student = studentService.getStudentByCode(code).orElseThrow(StudentNotFoundException::new);

        return student.getAvailableCredits();
    }

    @PostMapping("/student/{code}/credits/expend/{toExpend}")
    public Integer expendStudentCredits(@PathVariable Integer code, @PathVariable Integer toExpend)
    throws StudentNotFoundException, NotEnoughCreditsException {
        return studentService.expendCredits(code, toExpend);
    }
}
