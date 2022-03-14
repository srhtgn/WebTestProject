package com.webtestprojesi.wtp.requests;

import lombok.Data;

@Data
public class MyPermissionRequestsCreateRequest {
    Long id;
    Long permissionRequestFormId;
    String permitStartDate;
    String permitFinishDate;
    String approvalStatus;
}
