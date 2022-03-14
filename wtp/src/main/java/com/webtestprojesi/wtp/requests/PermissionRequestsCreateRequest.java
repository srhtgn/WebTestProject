package com.webtestprojesi.wtp.requests;

import lombok.Data;
@Data
public class PermissionRequestsCreateRequest {
    Long id;
    Long permissionRequestFormId;
    Long employeeId;

}
