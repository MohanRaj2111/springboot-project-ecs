package com.example.springboot_backend.controller;

import com.example.springboot_backend.model.Employee;
import com.example.springboot_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private  final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> saveEmployee(@Validated @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeID){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeID),HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeID,
                                                   @Validated @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,employeeID), HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeID){
        employeeService.deleteEmployee(employeeID);
        return new ResponseEntity<String>("Deleted successfully ",HttpStatus.OK);
    }
}
