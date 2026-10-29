package com.example.jobhunting.service;

import com.example.jobhunting.dto.Apply;
import com.example.jobhunting.repository.applicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class applicationService {
    private final applicationRepository applicationRepository;

    public applicationService(applicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Apply> findAllApplications(){
        return applicationRepository.findAllApplications();
    }
}
