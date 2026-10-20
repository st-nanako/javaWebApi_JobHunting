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
    public Company findCompanyById(long companyId) {
        return companyRepository.findCompanyById(companyId);
    }

    // 企業の新規登録
    public Company insertCompany(Company companyForm) {
        Company company = new Company();
        company.setName(companyForm.getName());
        company.setBusinessId(companyForm.getBusinessId());
        company.setPositionId(companyForm.getPositionId());
        company.setCompanyUrl(companyForm.getCompanyUrl());
        company.setMemo(companyForm.getMemo());

        companyRepository.insertCompany(company);
        return company;
    }

    // 企業の編集
    public Company updateCompany(Company companyForm , long companyId) {
        Company company = new Company();
        company.setName(companyForm.getName());
        company.setBusinessId(companyForm.getBusinessId());
        company.setPositionId(companyForm.getPositionId());
        company.setCompanyId(companyId);
        company.setCompanyUrl(companyForm.getCompanyUrl());
        company.setMemo(companyForm.getMemo());

        companyRepository.updateCompany(company);
        return company;
    }

    // 企業の削除
    public boolean deleteCompany(long companyId) {
        companyRepository.deleteCompany(companyId);
        return true;
    }
}
