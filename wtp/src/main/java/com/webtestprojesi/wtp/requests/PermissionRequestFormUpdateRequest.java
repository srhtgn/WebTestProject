package com.webtestprojesi.wtp.requests;

import lombok.Data;



@Data
public class PermissionRequestFormUpdateRequest {

    String permitStartDate;
    String permitFinishDate;
    Integer numberOfDaysOff;
}
