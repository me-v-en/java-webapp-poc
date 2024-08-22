package com.example.meven.webapp.controller;

import com.example.meven.webapp.model.Employee;
import com.example.meven.webapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        Employee e = new Employee();
        model.addAttribute("employee", e);
        // Return the content of the home.html file
        return "home";
    }

    @GetMapping("/employee/delete/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") final int id) {
        employeeService.deleteEmployee(id);
        // redirect to the home
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return new ModelAndView("redirect:/");
    }
}
