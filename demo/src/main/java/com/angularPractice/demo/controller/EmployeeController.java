package com.angularPractice.demo.controller;

import com.angularPractice.demo.entity.Employee;
import com.angularPractice.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiController")//address define
public class EmployeeController {


    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get")
    @CrossOrigin(origins = "*") // Allow Angular frontend access
    public ResponseEntity<List<Employee>> getEmployeeDat() {
        List<Employee> allemployeeData = employeeService.getAllemployeeData();
        return new ResponseEntity<>(allemployeeData, HttpStatus.OK);
    }

    @PostMapping("/save")
    @CrossOrigin(origins = "*") // Allow Angular frontend access
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
       Employee employee1= employeeService.saveEmployee(employee);
       return new ResponseEntity<>(employee1,HttpStatus.OK);

    }
}
