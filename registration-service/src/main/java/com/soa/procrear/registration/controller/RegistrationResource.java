package com.soa.procrear.registration.controller;

import com.soa.procrear.registration.dto.RegistrationDTO;
import com.soa.procrear.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationResource {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registration")
    public RegistrationDTO register(@RequestBody RegistrationDTO registrationDTO) throws Exception {
        return registrationService.register(registrationDTO);
    }
}
