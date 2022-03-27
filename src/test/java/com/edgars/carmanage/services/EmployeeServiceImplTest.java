package com.edgars.carmanage.services;

import com.edgars.carmanage.enums.Roles;
import com.edgars.carmanage.models.Car;
import com.edgars.carmanage.models.Employee;
import com.edgars.carmanage.repositories.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {

    @Test
    void whenAddedEmployeeReturnsList() {
        EmployeeRepo employeeRepo = mock(EmployeeRepo.class);
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
    void whenEmployeeIdNotFound() {
        EmployeeRepo employeeRepo = mock(EmployeeRepo.class);
        EmployeeService service = new EmployeeServiceImpl(employeeRepo);
        when(employeeRepo.findById(any())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.findEmpById(5L));
    }

    @Test
    void whenGivenIdEmployeeIsFound() {
        EmployeeRepo employeeRepo = mock(EmployeeRepo.class);
        EmployeeService service = new EmployeeServiceImpl(employeeRepo);
        List<Car> cars = new ArrayList<>();
        Long employeeId = 1L;
        Employee employee = new Employee(employeeId,
                "Jānis Paraudziņš",
                "Paraugs",
                "parole",
                "test@test.lv",
                12345678L,
                Roles.EMPLOYEE,
                cars);
        when(employeeRepo.findById(employeeId)).thenReturn(Optional.of(employee));
        Employee expected = service.findEmpById(employeeId);
        assertEquals(expected, employee);
    }

    @Test
    void whenGivenIdShouldDeleteEmployeeIfFound(){
        EmployeeRepo employeeRepo = mock(EmployeeRepo.class);
        EmployeeService service = new EmployeeServiceImpl(employeeRepo);
        List<Car> cars = new ArrayList<>();
        Long employeeId = 1L;
        Employee employee = new Employee(employeeId,
                "Jānis Paraudziņš",
                "Paraugs",
                "parole",
                "test@test.lv",
                12345678L,
                Roles.EMPLOYEE,
                cars);
        when(employeeRepo.findAll()).thenReturn(List.of(employee));
        service.deleteEmployee(employeeId);
        verify(employeeRepo).deleteById(employeeId);

    }
}