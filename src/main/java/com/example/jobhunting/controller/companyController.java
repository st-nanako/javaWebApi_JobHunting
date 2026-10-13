package com.example.jobhunting.controller;

import com.example.jobhunting.dto.Company;
import com.example.jobhunting.service.companyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class companyController {
    private final companyService companyService;

    public companyController(companyService companyService) {
        this.companyService = companyService;
    }
    // 会社一覧
    @GetMapping
    public List<Company> findAllCompany() {
        return companyService.findAllCompany();
    }

}
