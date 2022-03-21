package com.edgars.carmanage.services;

import com.edgars.carmanage.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Long id);
    List<Employee> allEmployees();
    void deleteEmployee(Long id);
    void deleteAllEmployees();

}
