package com.webtestprojesi.wtp.controllers;

import com.webtestprojesi.wtp.entities.Employee;
import com.webtestprojesi.wtp.services.EmployeeService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import com.webtestprojesi.wtp.repos.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {

		this.employeeService = employeeService;
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){

		return employeeService.getAllEmployees();
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee newEmployee){

		return employeeService.createOneEmployee(newEmployee);
	}

	@GetMapping("/{employeeId}")
	public  Employee getOneEmployee(@PathVariable Long employeeId){

		return employeeService.getOneEmployeeById(employeeId);
	}

	@PutMapping("/{employeeId}")
	public Employee updateOneEmployee(@PathVariable Long employeeId, @RequestBody Employee newEmployee){

		return employeeService.updateOneEmployee(employeeId, newEmployee);
	}

	@DeleteMapping("/{employeeId}")
	public void deeleteOneEmployee(@PathVariable Long employeeId){

		employeeService.deleteById(employeeId);
	}
}