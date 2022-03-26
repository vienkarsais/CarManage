package com.edgars.carmanage.services;

import com.edgars.carmanage.enums.Roles;
import com.edgars.carmanage.models.Car;
import com.edgars.carmanage.models.Employee;
import com.edgars.carmanage.repositories.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {


    @Mock
    private EmployeeRepo employeeRepo;

    @Test
    void whenAddedEmployeeReturnsList() {
        EmployeeService service = new EmployeeServiceImpl(employeeRepo);
        List<Car> cars = new ArrayList<>();
        List<Employee> employeeList = List.of(new Employee(
                1L,
                "Jānis Paraudziņš",
                "Paraugs",
                "parole",
                "test@test.lv",
                12345678L,
                Roles.EMPLOYEE,
                cars));
        when(employeeRepo.findAll()).thenReturn(employeeList);
        List<Employee> result = service.allEmployees();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void addEmployee() {
    }

    @Test
    void whenEmployeeIdNotFound() {
        EmployeeService service = new EmployeeServiceImpl(employeeRepo);
        when(employeeRepo.findById(any())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.findEmpById(5L));
    }

    @Test
    void deleteEmployee() {

    }
}