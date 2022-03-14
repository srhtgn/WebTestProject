package com.webtestprojesi.wtp.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name="permissionRequestDetail")
@Data
public class PermissionRequestDetail {
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.EAGER) //permissionRequestForm hemen çekilecek
    @JoinColumn(name = "permissionRequestForm_id", nullable = false)
    PermissionRequestForm permissionRequestForm;

    @ManyToOne(fetch = FetchType.EAGER) //employee hemen çekilecek
    @JoinColumn(name = "employee_id", nullable = false)
    Employee employee;

    String permitStartDate;
    String permitFinishDate;
    String numberOfDaysOff;
    Boolean approvalStatus;
}