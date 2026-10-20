package com.example.jobhunting.mapper;

import com.example.jobhunting.dto.Company;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface companyMapper {
    // 会社一覧
    @Select("SELECT * FROM companies")
    List<Company> findAllCompany();

    // IDの企業の取得
    @Select("SELECT * FROM companies WHERE company_id = #{companyId}")
    Company findCompanyById(int companyId);

    // 企業の新規登録
    @Insert("INSERT INTO companies (name,business_id,position_id,company_url,memo) " +
            "VALUES (#{name},#{businessId},#{positionId},#{companyUrl},#{memo})")
    void insertCompany(Company company);
}
