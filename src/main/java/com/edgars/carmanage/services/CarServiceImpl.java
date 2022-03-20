package com.edgars.carmanage.services;

import com.edgars.carmanage.models.Car;
import com.edgars.carmanage.repositories.CarRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{
    private CarRepo carRepo;

    @Override
    public Car addCar(Car car) {
        return null;
    }

    @Override
    public Car updateCar(Car car) {
        return null;
    }

    @Override
    public List<Car> showAllCars() {
        return null;
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
