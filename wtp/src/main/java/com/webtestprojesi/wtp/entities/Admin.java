package com.webtestprojesi.wtp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="admin")
@Data
public class Admin {

	@Id
	Long id;
	
	String adminName;
	Character password;
}
