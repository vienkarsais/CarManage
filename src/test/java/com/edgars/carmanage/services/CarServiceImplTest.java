package com.edgars.carmanage.services;

import com.edgars.carmanage.enums.FuelType;
import com.edgars.carmanage.enums.Gearbox;
import com.edgars.carmanage.models.Car;
import com.edgars.carmanage.models.Employee;
import com.edgars.carmanage.repositories.CarRepo;
import com.edgars.carmanage.repositories.EmployeeRepo;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CarServiceImplTest {

@Test
    void whenAddedCarReturnsList(){
        CarRepo carRepo = mock(CarRepo.class);
        EmployeeRepo employeeRepo = mock(EmployeeRepo.class);
        CarService carService = new CarServiceImpl(carRepo, employeeRepo);
        Employee employee = new Employee();
        employee.setId(1L);
        List<Car> carList = List.of(new Car(2L,
                employee,
           2L,
           "Volvo",
           "S80",
           2020,
                FuelType.DIESEL,
                Gearbox.AUTOMATIC,
                5,
                "url"));
        when(carRepo.findAll()).thenReturn(carList);
        List<Car> result = carService.showAllCars();
        assertNotNull(result);
        assertEquals(1, result.size());

    }
    @Test
    void whenCarIdNotFound() {
        CarRepo carRepo = mock(CarRepo.class);
        EmployeeRepo employeeRepo = mock(EmployeeRepo.class);
        CarService carService = new CarServiceImpl(carRepo, employeeRepo);
        when(carRepo.findById(any())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> carService.findById(5L));
    }

    @Test
    void whenGivenIdCarIsFound(){
        CarRepo carRepo = mock(CarRepo.class);
        EmployeeRepo employeeRepo = mock(EmployeeRepo.class);
        CarService carService = new CarServiceImpl(carRepo, employeeRepo);
        Employee employee = new Employee();
        employee.setId(1L);
        Long carId = 2L;
        Car car = new Car(2L,
                employee,
                2L,
                "Volvo",
                "S80",
                2020,
                FuelType.DIESEL,
                Gearbox.AUTOMATIC,
                5,
                "url");

        when(carRepo.findById(carId)).thenReturn(Optional.of(car));
        Car expected = carService.findById(carId);
        assertEquals(expected, car);
    }

    @Test
    void whenGivenIdShouldDeleteCarIfFound(){
        CarRepo carRepo = mock(CarRepo.class);
        EmployeeRepo employeeRepo = mock(EmployeeRepo.class);
        CarService carService = new CarServiceImpl(carRepo, employeeRepo);
        Employee employee = new Employee();
        employee.setId(1L);
        Long carId = 2L;
        Car car = new Car(2L,
                employee,
                2L,
                "Volvo",
                "S80",
                2020,
                FuelType.DIESEL,
                Gearbox.AUTOMATIC,
                5,
                "url");
        when(carRepo.findAll()).thenReturn(List.of(car));
        carService.deleteCar(carId);
        verify(carRepo).deleteById(carId);
    }
}
