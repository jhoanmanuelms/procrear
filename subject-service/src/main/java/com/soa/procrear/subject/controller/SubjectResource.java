package com.soa.procrear.subject.controller;

import com.soa.procrear.subject.exception.SubjectNotFoundException;
import com.soa.procrear.subject.model.Subject;
import com.soa.procrear.subject.service.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectResource {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subject")
    public List<Subject> getAllSubjects() {
        return subjectService.getSubjects();
    }

    @GetMapping("/subject/{code}")
    public Subject getSubjectByCode(@PathVariable String code) throws SubjectNotFoundException {
        return subjectService.getSubjectByCode(code).orElseThrow(SubjectNotFoundException::new);
    }
}
