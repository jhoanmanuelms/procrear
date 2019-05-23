package com.soa.procrear.average.controller;

import com.soa.procrear.average.dto.AverageDTO;
import com.soa.procrear.average.service.AverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AverageResource {
    @Autowired
    private AverageService averageService;

    @PostMapping("/average")
    public AverageDTO calculateAverage(@RequestBody Double[] values) {
        return averageService.calculateAverage(values);
    }
}
