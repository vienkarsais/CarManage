package com.edgars.carmanage.controllers;

import com.edgars.carmanage.models.Employee;
import com.edgars.carmanage.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeServiceImpl;

    @Autowired
    public EmployeeController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/form")
    public String employeeForm(Employee employee, Model model){
        return "/addEmployee";
    }

    @PostMapping("/addEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeServiceImpl.addEmployee(employee);
        return "redirect:/employee/allEmployees";
    }
    @GetMapping("/updateForm")
    public String employeeUpdateForm(@RequestParam("id")Long id, Model model){
        Employee employee = employeeServiceImpl.updateEmployee(id);
        model.addAttribute("employee", employee);
        return "/addEmployee";
    }

    @GetMapping("/allEmployees")
    public String allEmployees(Model model){
        List<Employee> employeeList = employeeServiceImpl.allEmployees();
        model.addAttribute("employeesList", employeeList);
        return "/allEmployees";
    }
    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") Long id){
        employeeServiceImpl.deleteEmployee(id);
        return "redirect:/employee/allEmployees";
    }



}
