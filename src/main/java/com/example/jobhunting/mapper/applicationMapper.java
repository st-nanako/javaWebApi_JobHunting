package com.example.jobhunting.mapper;

import com.example.jobhunting.dto.Apply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface applicationMapper {
    // 応募一覧
    @Select("SELECT * FROM applications")
    List<Apply> findAllApplications();

}
