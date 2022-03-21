package com.edgars.carmanage.services;

import com.edgars.carmanage.models.Employee;
import com.edgars.carmanage.repositories.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id) {
        Optional<Employee> maybeEmployee = employeeRepo.findById(id);
        if ((maybeEmployee.isEmpty())){
            throw new RuntimeException("Employee with id: " + id + " was not found.");
        }
        return maybeEmployee.get();
    }

    @Override
    public List<Employee> allEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepo.deleteAll();
    }
}
