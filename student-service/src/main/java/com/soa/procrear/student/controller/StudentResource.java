package com.soa.procrear.student.controller;

import com.soa.procrear.student.exception.NotEnoughCreditsException;
import com.soa.procrear.student.exception.StudentAlreadyExistingException;
import com.soa.procrear.student.exception.StudentNotFoundException;
import com.soa.procrear.student.model.Student;
import com.soa.procrear.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResource {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student register(@RequestBody Student student) throws StudentAlreadyExistingException {
        return studentService.save(student);
    }

    @GetMapping("/student/{code}")
    public Student getStudentByCode(@PathVariable Integer code) throws StudentNotFoundException {
        return studentService.getStudentByCode(code);
    }

    @GetMapping("/student/{code}/credits")
    public Integer getStudentCredits(@PathVariable Integer code) throws StudentNotFoundException {
        return studentService.getStudentByCode(code).getAvailableCredits();
    }

    @PostMapping("/student/{code}/credits/expend/{toExpend}")
    public Student expendStudentCredits(@PathVariable Integer code, @PathVariable Integer toExpend)
    throws StudentNotFoundException, NotEnoughCreditsException {
        return studentService.expendCredits(code, toExpend);
    }
}
