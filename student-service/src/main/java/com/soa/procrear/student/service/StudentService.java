package com.soa.procrear.student.service;

import com.soa.procrear.student.exception.NotEnoughCreditsException;
import com.soa.procrear.student.exception.StudentNotFoundException;
import com.soa.procrear.student.model.Student;
import com.soa.procrear.student.repository.StudentRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentByCode(Integer code) throws StudentNotFoundException {
        Student student = studentRepository.findByCode(code);

        if (student == null) {
            throw new StudentNotFoundException();
        }

        return student;
    }

    public Integer expendCredits(Integer code, Integer toExpend)
    throws StudentNotFoundException, NotEnoughCreditsException {
        Student student = getStudentByCode(code);
        Integer availableCredits = student.getAvailableCredits();
        Integer balance = availableCredits - toExpend;

        if (balance < 0) {
            throw new NotEnoughCreditsException();
        }

        student.setAvailableCredits(balance);
        studentRepository.save(student);

        return balance;
    }
}
