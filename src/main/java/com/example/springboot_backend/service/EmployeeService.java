package com.example.springboot_backend.service;

import com.example.springboot_backend.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee,long id);
    void deleteEmployee(Long id);
}
