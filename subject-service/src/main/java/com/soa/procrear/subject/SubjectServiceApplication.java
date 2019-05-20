package com.soa.procrear.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SubjectServiceApplication {
    public static void main(String... args) {
        SpringApplication.run(SubjectServiceApplication.class, args);
    }
}
