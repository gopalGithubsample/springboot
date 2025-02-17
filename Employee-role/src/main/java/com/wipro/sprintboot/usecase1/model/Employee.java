package com.wipro.sprintboot.usecase1.model;

public class Employee {

    private Integer id;
    private String name;
    private String role;
    private String designation;

    public Employee() { // No-args constructor (important for Spring)
    }

    public Employee(String name, String role) { // Constructor without ID
        this.name = name;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    // Override toString() for easier debugging (optional but recommended)
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}