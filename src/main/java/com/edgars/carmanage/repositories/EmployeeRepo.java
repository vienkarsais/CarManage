package com.edgars.carmanage.repositories;

import com.edgars.carmanage.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee findByUsername(String username);
}
