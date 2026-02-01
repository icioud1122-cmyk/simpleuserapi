package com.example.simpleuserapi;

import com.example.simpleuserapi.service.SampleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SimpleuserapiApplicationDb implements CommandLineRunner {

    private final SampleService sampleService;

    public SimpleuserapiApplicationDb(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @Override
    public void run(String... args) {
        sampleService.insert();
    }
}
