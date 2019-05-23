package com.soa.procrear.print.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PrintService {
    public String print(MultipartFile document) {
        // TODO Let's assume the file was sent to the printer
        String notification = "The document \"" + document.getOriginalFilename() + "\" has been printed";
        System.out.println(notification);

        return notification;
    }
}
