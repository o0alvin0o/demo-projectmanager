package com.jsp.pma.controller;

import com.jsp.pma.entities.Employee;
import com.jsp.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model) {
        empService.save(employee);
        return "redirect:new";
    }

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = empService.getAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

}
