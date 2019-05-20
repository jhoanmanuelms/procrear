package com.soa.procrear.subject.service;

import com.soa.procrear.subject.model.Subject;
import com.soa.procrear.subject.repository.SubjectRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectByCode(String code) {
        return Optional.ofNullable(subjectRepository.findByCode(code));
    }
}

