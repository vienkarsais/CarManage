package com.edgars.carmanage.services;

import com.edgars.carmanage.enums.Roles;
import com.edgars.carmanage.models.Employee;
import com.edgars.carmanage.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;
    private PasswordEncoder encoder;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo, PasswordEncoder encoder) {
        this.employeeRepo = employeeRepo;
        this.encoder = encoder;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if(employee.getRole() == null){
            employee.setRole(Roles.EMPLOYEE);
        }
        employee.setPassword(encoder.encode(employee.getPassword()));
        return employeeRepo.save(employee);
    }

    @Override
    public Employee findEmpById(Long id) {
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

    @Override
    public List<Employee> sortByRoles(Roles roles) {
        List<Employee> employeeList = employeeRepo.getEmployeesByRole(roles);
        return employeeList;
    }
}
