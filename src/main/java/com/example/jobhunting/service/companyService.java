package com.example.jobhunting.service;

import com.example.jobhunting.dto.Company;
import com.example.jobhunting.repository.companyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class companyService {
    private final companyRepository companyRepository;
    public companyService(companyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    // 会社一覧
    public List<Company> findAllCompany() {
        return companyRepository.findAllCompany();
    }

    // IDの企業の取得
    public Company findCompanyById(int companyId) {
        return companyRepository.findCompanyById(companyId);
    }
}
