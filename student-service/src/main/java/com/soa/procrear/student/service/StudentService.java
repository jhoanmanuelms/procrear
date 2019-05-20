package com.soa.procrear.student.service;

import com.soa.procrear.student.model.Student;
import com.soa.procrear.student.repository.StudentRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> getStudentByCode(Integer code) {
        return Optional.ofNullable(studentRepository.findByCode(code));
    }
}
