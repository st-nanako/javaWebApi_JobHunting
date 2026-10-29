package com.example.jobhunting.controller;

import com.example.jobhunting.dto.Apply;
import com.example.jobhunting.service.applicationService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/applications")

public class applicationController {
    private final applicationService applicationService;
    public applicationController(applicationService applicationService) {
        this.applicationService = applicationService;
    }
    // 全ての応募情報を取得
    @GetMapping
    public ResponseEntity<List<Apply>> findAllApplications(){
        List<Apply> applications = applicationService.findAllApplications();
        return ResponseEntity.ok(applications);
    }

}
