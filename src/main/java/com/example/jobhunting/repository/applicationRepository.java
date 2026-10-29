package com.example.jobhunting.repository;

import com.example.jobhunting.dto.Apply;
import com.example.jobhunting.mapper.applicationMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class applicationRepository {
    private final applicationMapper applicationMapper;

    public applicationRepository(applicationMapper applicationMapper) {
        this.applicationMapper = applicationMapper;
    }

    // 応募一覧
    public List<Apply> findAllApplications(){
        return applicationMapper.findAllApplications();
    }
}
