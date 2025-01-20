package com.example.springboot_backend.repository;

import com.example.springboot_backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
