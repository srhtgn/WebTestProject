package com.webtestprojesi.wtp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="myPermissionRequests")
@Data
public class MyPermissionRequests {
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.EAGER) //permissionRequestForm hemen ├žekilecek
    @JoinColumn(name = "permissionRequestForm_id", nullable = false)
    PermissionRequestForm permissionRequestForm;

    String permitStartDate;
    String permitFinishDate;
    String approvalStatus;
    String numberOfDaysOff;
}