package com.soa.procrear.average.service;

import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class AverageService {
    public Double calculateAverage(Double[] values) {
        Double total = Stream.of(values).reduce(0.0, (prev, curr) -> prev + curr);
        return total / values.length;
    }
}
