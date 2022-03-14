package com.webtestprojesi.wtp.requests;

import lombok.Data;

@Data
public class AdminCreateRequest {
    Long id;
    String adminName;
    Character password;
}
