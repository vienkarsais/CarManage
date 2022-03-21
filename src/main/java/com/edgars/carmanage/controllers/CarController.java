package com.edgars.carmanage.controllers;

import com.edgars.carmanage.models.Car;
import com.edgars.carmanage.models.Employee;
import com.edgars.carmanage.services.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/car")
public class CarController {
    private CarService carServiceImpl;
    @Autowired
    public CarController(CarService carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping("allCars")
    public String showAllCars(Model model) {
        List<Car> carList = carServiceImpl.showAllCars();
        model.addAttribute("carList", carList);
        return "/allCars";
    }

    @GetMapping("/carForm")
    public String showCarForm(Car car, Model model) {
        model.addAttribute("car", car);
        return "/addCar";
    }

    @PostMapping("/addCar")
    public String saveCar(@ModelAttribute("car") Car car) {
        carServiceImpl.addCar(car);
        return "redirect:/car/allCars";
    }
    @GetMapping("/updateForm")
    public String employeeUpdateForm(@RequestParam("id")Long id, Model model){
        Car car = carServiceImpl.updateCar(id);
        model.addAttribute("car", car);
        return "/addCar";
    }
    @GetMapping("/deleteCar")
    public String deleteCar(@RequestParam("id") Long id){
        carServiceImpl.deleteCar(id);
        return "redirect:/car/allCars";
    }



}
