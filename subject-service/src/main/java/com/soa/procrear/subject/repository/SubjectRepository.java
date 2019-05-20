package com.soa.procrear.subject.repository;

import com.soa.procrear.subject.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findByCode(String code);
}
