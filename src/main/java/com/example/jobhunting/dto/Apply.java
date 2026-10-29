package com.example.jobhunting.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Apply {
    private long applicationId;
    private String name;
    private long companyId;
    private LocalDate application_date ;
    private long typeId;
    private long statusId;
    private LocalDate scheduleStartDate;
    private LocalDate scheduleEndDate;
    private String memo;
}
