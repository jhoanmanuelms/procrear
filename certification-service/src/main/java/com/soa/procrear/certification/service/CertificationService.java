package com.soa.procrear.certification.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.soa.procrear.certification.configuration.CompositionConfig;
import com.soa.procrear.certification.dto.CertificationDTO;
import com.soa.procrear.certification.dto.CourseDTO;
import com.soa.procrear.certification.dto.StudentDTO;
import com.soa.procrear.certification.exception.CourseNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.entity.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class CertificationService {
    @Autowired
    private CompositionConfig compositionConfig;

    public CertificationDTO generateCertification(Integer studentCode) throws Exception {
        JSONArray courses = getCourses(studentCode).getArray();
        List<CourseDTO> courseDTOs = getCourseDTOs(courses);
        StudentDTO studentDTO = getStudentDTO(studentCode);
        String average = getAverage(courseDTOs);
        printCertificate();

        return new CertificationDTO(studentDTO, courseDTOs, average);
    }

    private StudentDTO getStudentDTO(Integer studentCode) throws CourseNotFoundException, UnirestException {
        JsonNode student = getStudent(studentCode);
        String name = (String)(student.getObject().get("name"));
        String lastName = (String)(student.getObject().get("lastName"));

        return new StudentDTO(studentCode, name + " " + lastName);
    }

    private List<CourseDTO> getCourseDTOs(JSONArray courses) throws CourseNotFoundException, UnirestException {
        List<CourseDTO> courseDTOs = new ArrayList<>();

        for (Object course : courses) {
            JSONObject jsonCourse = (JSONObject)course;
            Double grade = (Double)(jsonCourse.get("grade"));
            String subjectCode = (String)(jsonCourse.get("subjectCode"));

            JsonNode subject = getSubject(subjectCode);
            String subjectName = (String)(subject.getObject().get("name"));

            courseDTOs.add(new CourseDTO(subjectCode, subjectName, grade));
        }

        return courseDTOs;
    }

    private String getAverage(List<CourseDTO> courseDTOs) throws JsonProcessingException, UnirestException {
        double[] grades = courseDTOs.stream().mapToDouble(CourseDTO::getGrade).toArray();
        JsonNode response =
                Unirest.post(compositionConfig.getAverageService())
                        .header("Content-type", "application/json")
                        .body(new ObjectMapper().writeValueAsString(grades))
                        .asJson()
                        .getBody();

        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMaximumFractionDigits(1);

        return formatter.format(response.getObject().get("average"));
    }

    private void printCertificate() throws IOException, UnirestException {
        // TODO Let's pretend the certificate was generated
        File certificate = ResourceUtils.getFile("classpath:Certificate.pdf");
        InputStream toPrint = Files.newInputStream(certificate.toPath());

        Unirest.post(compositionConfig.getPrintService())
                .field("document", toPrint, ContentType.APPLICATION_OCTET_STREAM, "Certificate.pdf")
                .asString();
    }

    private JsonNode getCourses(Integer studentCode) throws CourseNotFoundException, UnirestException {
        String endpoint = compositionConfig.getCourseService() + "/student/" + studentCode;
        return get(endpoint);
    }

    private JsonNode getSubject(String subjectCode) throws CourseNotFoundException, UnirestException {
        String endpoint = compositionConfig.getSubjectService() + "/" + subjectCode;
        return get(endpoint);
    }

    private JsonNode getStudent(Integer studentCode) throws CourseNotFoundException, UnirestException {
        String endpoint = compositionConfig.getStudentService() + "/" + studentCode;
        return get(endpoint);
    }

    private JsonNode get(String endpoint) throws CourseNotFoundException, UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(endpoint).asJson();

        if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            throw new CourseNotFoundException();
        }

        return response.getBody();
    }
}
