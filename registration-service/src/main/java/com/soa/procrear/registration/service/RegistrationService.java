package com.soa.procrear.registration.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.soa.procrear.registration.configuration.CompositionConfig;
import com.soa.procrear.registration.dto.RegistrationDTO;
import com.soa.procrear.registration.exception.InvalidRegistrationException;
import com.soa.procrear.registration.exception.NotEnoughCreditsException;
import com.soa.procrear.registration.exception.StudentAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private CompositionConfig compositionConfig;

    public RegistrationDTO register(RegistrationDTO registrationDTO) throws Exception {
        JsonNode student = getStudent(registrationDTO.getStudentCode());
        JsonNode subject = getSubject(registrationDTO.getSubjectCode());

        validateCredits(subject, student);
        registerCourse(registrationDTO);
        expendCredits(subject, student);

        return registrationDTO;
    }

    private void validateCredits(JsonNode subject, JsonNode student) throws NotEnoughCreditsException {
        Integer subjectCredits = (Integer)subject.getObject().get("credits");
        Integer studentCredits = (Integer)student.getObject().get("availableCredits");

        if (studentCredits - subjectCredits < 0) {
            throw new NotEnoughCreditsException();
        }
    }

    private void registerCourse(RegistrationDTO registrationDTO)
    throws JsonProcessingException, StudentAlreadyRegisteredException, UnirestException {
        String endpoint = compositionConfig.getCourseService() + "/course";
        ObjectMapper mapper = new ObjectMapper();
        registrationDTO.setGrade(0.0);

        HttpResponse<JsonNode> response =
            Unirest.post(endpoint)
                .header("Content-type", "application/json")
                .body(mapper.writeValueAsBytes(registrationDTO)).asJson();

        if (response.getStatus() == HttpStatus.CONFLICT.value()) {
            throw new StudentAlreadyRegisteredException();
        }
    }

    private void expendCredits(JsonNode subject, JsonNode student) throws UnirestException {
        Integer studentCode = (Integer)student.getObject().get("code");
        Integer subjectCredits = (Integer)subject.getObject().get("credits");
        String endpoint =
            compositionConfig.getStudentService() + "/student/" + studentCode + "/credits/expend/" + subjectCredits;

        Unirest.post(endpoint).asJson();
    }

    private JsonNode getSubject(String subjectCode) throws InvalidRegistrationException, UnirestException {
        String endpoint = compositionConfig.getSubjectService() + "/subject/" + subjectCode;
        return get(endpoint);
    }

    private JsonNode getStudent(Integer studentCode) throws InvalidRegistrationException, UnirestException {
        String endpoint = compositionConfig.getStudentService() + "/student/" + studentCode;
        return get(endpoint);
    }

    private JsonNode get(String endpoint) throws InvalidRegistrationException, UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(endpoint).asJson();

        if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            throw new InvalidRegistrationException();
        }

        return response.getBody();
    }
}
