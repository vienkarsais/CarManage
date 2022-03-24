package com.edgars.carmanage.controllers;

import com.edgars.carmanage.services.CarService;
import com.edgars.carmanage.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class AppController {
    private EmployeeService employeeServiceImpl;
    private CarService carServiceImpl;
    @Autowired
    public AppController(EmployeeService employeeServiceImpl, CarService carServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping("/")
    public String welcomeScreen(){
        return "redirect:/employee/allEmployees";
    }

    @GetMapping("/main")
    public String mainPage(){
        return "main";
    }

    @PostMapping("/login")
    public String authorizeEmployee(){

        return "redirect:/main";
    }

}
