package com.soa.procrear.print.controller;

import com.soa.procrear.print.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PrintResource {
    @Autowired
    private PrintService printService;

    @PostMapping("/print")
    public String print(@RequestParam MultipartFile document) {
        return printService.print(document);
    }
}
