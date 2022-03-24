package com.edgars.carmanage.repositories;

import com.edgars.carmanage.enums.Roles;
import com.edgars.carmanage.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee getEmployeeByUsername(String username);
    List<Employee> getEmployeesByRole(Roles roles);
}
