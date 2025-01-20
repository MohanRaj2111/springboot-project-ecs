package com.example.springboot_backend.service;

import com.example.springboot_backend.exception.ResourceNotFoundException;
import com.example.springboot_backend.model.Employee;
import com.example.springboot_backend.repository.EmployeeRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplement implements  EmployeeService{


    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImplement(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
//      Optional<Employee> employee = employeeRepository.findById(id);
//       if(employee.isPresent()){
//           return employee.get();
//       }else{
//           throw new ResourceNotFoundException("Employee", "Id","id");
//       }
        return employeeRepository.findById(id).orElseThrow( () ->
                new ResourceNotFoundException("Employee","ID","id"));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow( () ->
                new ResourceNotFoundException("Employee","ID","id"));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setPassword(employee.getPassword());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setRollNumber(employee.getRollNumber());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Empployee","ID","id"));
        employeeRepository.deleteById(id);
    }


}
