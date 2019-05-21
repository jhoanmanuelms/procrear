package com.soa.procrear.student.repository;

import com.soa.procrear.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByCode(Integer code);

    Integer countByCode(Integer code);
}
