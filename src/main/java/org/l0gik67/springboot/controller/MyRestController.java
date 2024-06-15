package org.l0gik67.springboot.controller;


import org.l0gik67.springboot.entity.Employee;
import org.l0gik67.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping()
    public List<Employee> showAllEmployees(){
        List<Employee> emps = employeeService.getAllEmployees();
        return emps;
    }
    @GetMapping("/{id}")
    public Employee getEmp(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @PostMapping()
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee){
        updateEmployee(employee);
        return employee;
    }



    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
