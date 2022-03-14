package com.webtestprojesi.wtp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="permissionRequestForm")
@Data
public class PermissionRequestForm {
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonIgnore
    Employee employee;

    String permitStartDate;
    String permitFinishDate;

    Integer numberOfDaysOff;
}