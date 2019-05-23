package com.soa.procrear.certification.controller;

import com.soa.procrear.certification.dto.CertificationDTO;
import com.soa.procrear.certification.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CertificationResource {
    @Autowired
    private CertificationService certificationService;

    @GetMapping("/certificate/{studentCode}")
    public CertificationDTO generateCertification(@PathVariable Integer studentCode) throws Exception {
        return certificationService.generateCertification(studentCode);
    }
}
