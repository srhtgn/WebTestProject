package com.webtestprojesi.wtp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webtestprojesi.wtp.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
