package com.wipro.sprintboot.usecase1.service;

import com.wipro.sprintboot.usecase1.model.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EmployeeService {

    private Map<Integer, Employee> employees = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public Employee addEmployee(Employee employee) {
        employee.setId(idCounter.getAndIncrement()); // Use the setter
        updateDesignation(employee);
        employees.put(employee.getId(), employee); // Use the getter
        return employee;
    }

    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Employee existingEmployee = employees.get(id);
        if (existingEmployee != null) {
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setRole(updatedEmployee.getRole());
            updateDesignation(existingEmployee);
            return existingEmployee;
        }
        return null;
    }

    private void updateDesignation(Employee employee) {
        employee.setDesignation(getDesignationByRole(employee.getRole()));
    }

    private String getDesignationByRole(String role) {
        if (role == null) {
            return "Unknown";
        }

        switch (role.toLowerCase()) {
            case "developer":
                return "Developer";
            case "tester":
                return "Tester";
            case "architect":
                return "Architect";
            default:
                return "Unknown";
        }
    }

    public Employee getEmployee(int id) {
        return employees.get(id); // Use the getter
    }
}