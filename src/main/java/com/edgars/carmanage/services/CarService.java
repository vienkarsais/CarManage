package com.edgars.carmanage.services;

import com.edgars.carmanage.models.Car;

import java.util.List;
public interface CarService {
    Car addCar(Car car);
    Car updateCar(Long id);
    List<Car> showAllCars();
    void deleteCar(Long id);
    void deleteAllCars();
}
