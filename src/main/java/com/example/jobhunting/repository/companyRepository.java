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
}
