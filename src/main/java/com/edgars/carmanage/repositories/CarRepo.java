package com.edgars.carmanage.repositories;

import com.edgars.carmanage.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, Long> {
}
