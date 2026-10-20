package com.example.jobhunting.repository;

import com.example.jobhunting.dto.Company;
import com.example.jobhunting.mapper.companyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class companyRepository {
    private final companyMapper companyMapper;
    public companyRepository(companyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }
    // 会社一覧
    public List<Company> findAllCompany() {
        return companyMapper.findAllCompany();
    }

    // IDの企業の取得
    public Company findCompanyById(long companyId) {
        return companyMapper.findCompanyById(companyId);
    }

    // 企業の新規登録
    public void insertCompany(Company company) {
        companyMapper.insertCompany(company);
    }

    // 企業の編集
    public void updateCompany(Company company) {
        companyMapper.updateCompany(company);
    }
}
