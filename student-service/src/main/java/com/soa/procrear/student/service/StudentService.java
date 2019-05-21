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

    public Optional<Student> getStudentByCode(Integer code) {
        return Optional.ofNullable(studentRepository.findByCode(code));
    }

    public Integer expendCredits(Integer code, Integer toExpend)
    throws StudentNotFoundException, NotEnoughCreditsException {
        Student student = getStudentByCode(code).orElseThrow(StudentNotFoundException::new);
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
