package com.edgars.carmanage.controllers;

import com.edgars.carmanage.enums.Roles;
import com.edgars.carmanage.models.Employee;
import com.edgars.carmanage.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeServiceImpl;

    @Autowired
    public EmployeeController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/form")
    public String employeeForm(Employee employee, Model model){
        return "/addEmployee";
    }

    @PostMapping("/addEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result){
        if (result.hasErrors()){
            log.error(String.valueOf(result));
            return "redirect:/employee/form";
        }
        employeeServiceImpl.addEmployee(employee);
        return "redirect:/employee/allEmployees";
    }
    @GetMapping("/updateForm")
    public String employeeUpdateForm(@RequestParam("id")Long id, Model model){
        Employee employee = employeeServiceImpl.findEmpById(id);
        
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
    @GetMapping("deleteAll")
    public String deleteAllEmp(){
        employeeServiceImpl.deleteAllEmployees();
        return "redirect:/employee/allEmployees";
    }

    @GetMapping("/managerList")
    public String allManagers(Model model){
        List<Employee> managerList = employeeServiceImpl.sortByRoles(Roles.MANAGER);
        model.addAttribute("managerList", managerList);
        return "/managerList";
    }



}
