package com.webtestprojesi.wtp.requests;

import lombok.Data;

@Data
public class EmployeeCreateRequest {

    Long id;
    String employeeName	;
    Character password;
}
