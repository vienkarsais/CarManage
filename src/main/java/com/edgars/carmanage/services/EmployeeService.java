package com.edgars.carmanage.services;

import com.edgars.carmanage.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    List<Employee> allEmployees();
    void deleteEmployee(Long id);
    void deleteAllEmployees();

}
