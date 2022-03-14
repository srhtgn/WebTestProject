package com.webtestprojesi.wtp.requests;

import lombok.Data;

@Data
public class PermissionRequestDetailUpdateRequest {

    String permitStartDate;
    String permitFinishDate;
    String numberOfDaysOff;
    Boolean approvalStatus;
}
