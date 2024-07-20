package com.gulshan.springboot.thymeleafdemo.controller;

import com.gulshan.springboot.thymeleafdemo.entity.Employee;
import com.gulshan.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees/listEmployees";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/employeeForm";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("employeeId") int empId, Model model) {
        model.addAttribute("employee", employeeService.findById(empId));
        return "employees/employeeForm";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int empId) {
        employeeService.deleteById(empId);
        return "redirect:/employees/list";
    }
}
