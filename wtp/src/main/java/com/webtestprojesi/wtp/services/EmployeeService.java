package com.webtestprojesi.wtp.services;

import com.webtestprojesi.wtp.entities.Employee;
import com.webtestprojesi.wtp.repos.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createOneEmployee(Employee newEmployee) {

        return employeeRepository.save(newEmployee);
    }

    public Employee getOneEmployeeById(Long employeeId) {

        return employeeRepository.findById(employeeId).orElse(null);
    }

    public Employee updateOneEmployee(Long employeeId, Employee newEmployee) {

        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if(employee.isPresent()){
            Employee foundEmployee = employee.get();
            foundEmployee.setEmployeeName(newEmployee.getEmployeeName());
            foundEmployee.setPassword(newEmployee.getPassword());
            employeeRepository.save(foundEmployee);
            return foundEmployee;
        }
        else{
            return null;
        }
    }
    public void deleteById(Long employeeId) {

        employeeRepository.deleteById(employeeId);
    }
}
