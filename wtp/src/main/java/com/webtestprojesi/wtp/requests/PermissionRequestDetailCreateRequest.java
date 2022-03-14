package com.webtestprojesi.wtp.requests;

import lombok.Data;

@Data
public class PermissionRequestDetailCreateRequest {

    Long id;
    String permitStartDate;
    String permitFinishDate;
    String numberOfDaysOff;
    Boolean approvalStatus;
}
