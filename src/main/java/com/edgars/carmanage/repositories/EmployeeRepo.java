package com.edgars.carmanage.repositories;

import com.edgars.carmanage.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee getEmployeeByUsername(String username);
}
