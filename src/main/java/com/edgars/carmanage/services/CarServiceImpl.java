package com.edgars.carmanage.services;

import com.edgars.carmanage.models.Car;
import com.edgars.carmanage.repositories.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{
    private CarRepo carRepo;
    @Autowired
    public CarServiceImpl(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @Override
    public Car addCar(Car car) {
        return carRepo.save(car);
    }

    @Override
    public Car updateCar(Long id) {
        Optional<Car> maybeCar = carRepo.findById(id);

        if (maybeCar.isEmpty()) {
            throw new RuntimeException("Car with id: " + id + " was not found.");
        }

        return maybeCar.get();
    }

    @Override
    public List<Car> showAllCars() {
       return carRepo.findAll();
    }

    @Override
    public void deleteCar(Long id) {
        carRepo.deleteById(id);
    }

    @Override
    public void deleteAllCars() {
        carRepo.deleteAll();
    }
}
