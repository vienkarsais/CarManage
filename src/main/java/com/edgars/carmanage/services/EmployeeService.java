package com.edgars.carmanage.services;

import com.edgars.carmanage.enums.Roles;
import com.edgars.carmanage.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee findEmpById(Long id);
    List<Employee> allEmployees();
    void deleteEmployee(Long id);
    void deleteAllEmployees();
    List<Employee> sortByRoles(Roles roles);
}
