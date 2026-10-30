package com.example.jobhunting.mapper;

import com.example.jobhunting.dto.Apply;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface applicationMapper {
    // 応募一覧
    @Select("SELECT * FROM applications")
    List<Apply> findAllApplications();

    // IDの応募の取得
    @Select("SELECT * FROM applications WHERE application_id  = #{applicationId}")
    Apply findApplicationById(long applicationId);

    // 応募の新規登録
    @Insert("INSERT INTO applications (name,company_id,application_date,type_id,status_id,schedule_start_date,schedule_end_date,memo)" +
            "VALUES (#{name},#{companyId},#{applicationDate},#{typeId},#{statusId},#{scheduleStartDate},#{scheduleEndDate},#{memo})")
    void insertApplication(Apply application);

    // 応募の編集
    @Update("UPDATE applications SET name = #{name},company_id = #{companyId},application_date = #{applicationDate},type_id = #{typeId},status_id = #{statusId},schedule_start_date = #{scheduleStartDate},schedule_end_date = #{scheduleEndDate},memo = #{memo} WHERE application_id = #{applicationId}")
    void updateApplication(Apply application);

    // 応募の削除
    @Delete("DELETE FROM applications WHERE application_id = #{applicationId}")
    long deleteApplicationById(long applicationId);

}
