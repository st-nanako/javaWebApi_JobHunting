package com.example.jobhunting.dto;

import lombok.Data;

@Data
public class Company {
    private long companyId;
    private String name;
    private long businessId;
    private long positionId;
    private String companyUrl;
    private String memo;
}
