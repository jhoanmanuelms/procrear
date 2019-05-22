package com.soa.procrear.registration.controller;

import com.soa.procrear.registration.dto.RegistrationDTO;
import com.soa.procrear.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationResource {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration")
    public RegistrationDTO register() {
        return registrationService.register();
    }
}
