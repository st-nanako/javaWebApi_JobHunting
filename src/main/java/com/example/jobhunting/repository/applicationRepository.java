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

    // IDの応募を取得
    public Apply findApplicationById(long applicationId){
        return applicationMapper.findApplicationById(applicationId);
    }

    // 応募の新規登録
    public void insertApplication(Apply application){
        applicationMapper.insertApplication(application);
    }

    // 応募の編集
    public void updateApplication(Apply application){
        applicationMapper.updateApplication(application);
    }

    // 応募の削除
    public void deleteApplicationById(long applicationId){
        applicationMapper.deleteApplicationById(applicationId);
    }
}
