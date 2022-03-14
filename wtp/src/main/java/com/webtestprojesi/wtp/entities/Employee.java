package com.webtestprojesi.wtp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="employee")
@Data
public class Employee {

	@Id
	Long id;
	
	String employeeName	;
	Character password;
}
