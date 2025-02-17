package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
@Service
public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmps();
	Employee updateEmpById(int id,Employee employee);
	List<Employee> getAllEmployees();

}