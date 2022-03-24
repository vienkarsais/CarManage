package com.edgars.carmanage.controllers;

import com.edgars.carmanage.models.Car;
import com.edgars.carmanage.models.Employee;
import com.edgars.carmanage.services.CarService;
import com.edgars.carmanage.services.EmployeeService;
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
    private EmployeeService employeeServiceImpl;
    @Autowired
    public CarController(CarService carServiceImpl, EmployeeService employeeServiceImpl) {
        this.carServiceImpl = carServiceImpl;
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("allCars")
    public String showAllCars(Model model) {
        List<Car> carList = carServiceImpl.showAllCars();
        model.addAttribute("carList", carList);
        return "/allCars";
    }

    @GetMapping("/carForm")
    public String showCarForm(Car car, Model model) {
        List<Employee> employeeList = employeeServiceImpl.allEmployees();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("car", car);
        return "/addCar";
    }

    @PostMapping("/addCar")
    public String saveCar(@ModelAttribute("car") Car car) {
        carServiceImpl.addCar(car);
        return "redirect:/car/allCars";
    }
    @GetMapping("/updateForm")
    public String carUpdateForm(@RequestParam("id")Long id, Model model){
        Car car = carServiceImpl.findById(id);
        model.addAttribute("car", car);
        return "/addCar";
    }
    @GetMapping("/deleteCar")
    public String deleteCar(@RequestParam("id") Long id){
        carServiceImpl.deleteCar(id);
        return "redirect:/car/allCars";
    }

    @GetMapping("/deleteAll")
    public String deleteAllCars(){
        carServiceImpl.deleteAllCars();
        return "redirect:/car/allCars";
    }




}
