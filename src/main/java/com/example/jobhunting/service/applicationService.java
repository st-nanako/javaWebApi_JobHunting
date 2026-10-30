package com.example.jobhunting.service;

import com.example.jobhunting.dto.Apply;
import com.example.jobhunting.mapper.applicationMapper;
import com.example.jobhunting.repository.applicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class applicationService {
    private final applicationRepository applicationRepository;

    public applicationService(applicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }
    // 全ての応募を取得
    public List<Apply> findAllApplications(){
        return applicationRepository.findAllApplications();
    }

    // IDの応募の取得
    public Apply findApplicationById(long applicationId){
        return applicationRepository.findApplicationById(applicationId);
    }

    // 応募の新規登録
    public Apply insertApplication(Apply applicationForm){
        Apply application = new Apply();
        application.setName(applicationForm.getName());
        application.setApplicationDate(applicationForm.getApplicationDate());
        application.setCompanyId(applicationForm.getCompanyId());
        application.setStatusId(applicationForm.getStatusId());
        application.setScheduleStartDate(applicationForm.getScheduleStartDate());
        application.setScheduleEndDate(applicationForm.getScheduleEndDate());
        application.setTypeId(applicationForm.getTypeId());
        application.setMemo(applicationForm.getMemo());

        applicationRepository.insertApplication(application);

        return application;
    }

    // 応募の編集
    public Apply updateApplication(Apply application , long id){
        applicationRepository.updateApplication(application);
        return application;
    }

    // 応募の削除
    public void deleteApplicationById(long applicationId){
        applicationRepository.deleteApplicationById(applicationId);
    }
}
