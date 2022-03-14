package com.webtestprojesi.wtp.requests;

import lombok.Data;

@Data
public class MyPermissionRequestsUpdateRequest {

    String permitStartDate;
    String permitFinishDate;
    String approvalStatus;
    String numberOfDaysOff;
}
