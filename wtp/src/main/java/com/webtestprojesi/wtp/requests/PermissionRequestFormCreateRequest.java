package com.webtestprojesi.wtp.requests;

import lombok.Data;



@Data
public class PermissionRequestFormCreateRequest {

    Long İd;
    String permitStartDate;
    String permitFinishDate;
    Integer numberOfDaysOff;
    Long employeeId;
}
