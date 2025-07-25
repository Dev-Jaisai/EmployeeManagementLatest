package com.angularPractice.demo.service;

import com.angularPractice.demo.entity.Employee;
import com.angularPractice.demo.repo.EmployeeRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

//    private static final Logger AUDIT_LOGGER = LoggerFactory.getLogger("audit.logger");

//    public String saveEmployee(Employee e) {
//        employeeRepo.save(e);
//
//        AUDIT_LOGGER.info("User created something important");
//
//
//        return "Employee data has been save";
//    }

    public List<Employee> getAllemployeeData() {
        List<Employee> all = employeeRepo.findAll();
        return all;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
/*
    public Page<Employee> findByPagination(int page, int size, String sortBy) {

        Pageable pageRequest = PageRequest.of(page, size, Sort.by(sortBy));

        return employeeRepo.findAll(pageRequest);
    }

    public Employee findUserById(int id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found Exception"));

    }

    public String deleteEmployeeById(int id) {

        employeeRepo.deleteById(id);
        return "Employee deleted";
    }*/
}
