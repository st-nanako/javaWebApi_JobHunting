package com.example.jobhunting.controller;

import com.example.jobhunting.dto.Company;
import com.example.jobhunting.service.companyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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

    // 企業の新規登録
    @PostMapping("/register")
    public ResponseEntity<Company> insertCompany(@RequestBody Company company,
                                                 UriComponentsBuilder uriBuilder) {
        System.out.println(company);
        Company createCompany = companyService.insertCompany(company);

        URI location = uriBuilder.path("/api/companies/{id}")
                .buildAndExpand(createCompany.getCompanyId()).toUri();

        return ResponseEntity.created(location).body(createCompany);
    }

}
