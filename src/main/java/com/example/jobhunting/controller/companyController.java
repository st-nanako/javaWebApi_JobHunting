package com.example.jobhunting.controller;

import com.example.jobhunting.dto.Company;
import com.example.jobhunting.mapper.companyMapper;
import com.example.jobhunting.service.companyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<List<Company>> findAllCompany() {
        List<Company> companies = companyService.findAllCompany();
        return ResponseEntity.ok(companies);
    }

    // IDの企業の取得
    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable int id) {
        Company company = companyService.findCompanyById(id);
        return ResponseEntity.ok(company);
    }

}
