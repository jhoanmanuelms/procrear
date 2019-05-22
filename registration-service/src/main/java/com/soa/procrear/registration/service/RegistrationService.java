package com.soa.procrear.registration.service;

import com.soa.procrear.registration.dto.RegistrationDTO;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public RegistrationDTO register() {
        Client client = ClientBuilder.newClient();
        Integer credits = client.target("http://localhost:8082/student/123456/credits").request().get(Integer.class);

        return new RegistrationDTO();
    }
}
