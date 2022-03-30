package com.edgars.carmanage.controllers;

import com.edgars.carmanage.services.CarService;
import com.edgars.carmanage.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
public class AppController {
    private final EmployeeService employeeServiceImpl;
    private final CarService carServiceImpl;
    @Autowired
    public AppController(EmployeeService employeeServiceImpl, CarService carServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
        this.carServiceImpl = carServiceImpl;
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
