package com.webtestprojesi.wtp.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name="permissionRequests")
@Data
public class PermissionRequests {
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.EAGER) //permissionRequestForm hemen çekilecek
    @JoinColumn(name = "permissionRequestForm_id", nullable = false)
    PermissionRequestForm permissionRequestForm;

    @ManyToOne(fetch = FetchType.EAGER) //employee hemen çekilecek
    @JoinColumn(name = "employee_id", nullable = false)
    Employee employee;

	public void setPermissionRequestForm(PermissionRequestForm permissionRequestForm2) {
		// TODO Auto-generated method stub
		
	}

	public void setEmployee(Employee employee2) {
		// TODO Auto-generated method stub
		
	}

}