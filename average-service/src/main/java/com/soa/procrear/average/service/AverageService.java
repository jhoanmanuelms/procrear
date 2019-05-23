package com.soa.procrear.average.service;

import com.soa.procrear.average.dto.AverageDTO;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class AverageService {
    public AverageDTO calculateAverage(Double[] values) {
        Double average = Stream.of(values).mapToDouble(Double::doubleValue).average().getAsDouble();
        return new AverageDTO(average);
    }
}
