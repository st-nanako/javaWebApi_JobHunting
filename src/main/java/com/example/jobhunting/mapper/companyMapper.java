package com.example.jobhunting.mapper;

import com.example.jobhunting.dto.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface companyMapper {
    // 会社一覧
    @Select("SELECT * FROM companies")
    List<Company> findAllCompany();

    // IDの企業の取得
    @Select("SELECT * FROM companies WHERE company_id = #{companyId}")
    Company findCompanyById(long companyId);

    // 企業の新規登録
    @Insert("INSERT INTO companies (name,business_id,position_id,company_url,memo) " +
            "VALUES (#{name},#{businessId},#{positionId},#{companyUrl},#{memo})")
    void insertCompany(Company company);

    // 企業の編集
    @Update("UPDATE companies SET name = #{name},business_id = #{businessId},position_id = #{positionId},company_url = #{companyUrl},memo = #{memo} " +
            "WHERE company_id = #{companyId}")
    void updateCompany(Company company);

    // 企業の削除
    @Delete("DELETE FROM companies WHERE company_id = #{companyId}")
    long deleteCompany(long companyId);
}
