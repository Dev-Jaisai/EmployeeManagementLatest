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
import java.util.Optional;

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

    public Employee saveEmployee(Employee employee) {//accepting employee object from controller
        return employeeRepo.save(employee);//using save repo method it wiull returm entity
    }

    public String deleteById(int id) {
        //service

        Optional<Employee> byId = employeeRepo.findById(id);

        if (byId.isPresent()) {
            employeeRepo.deleteById(id);
            return "Deleted data By id " + id + " ";
        } else {
            return "return data not found";
        }
    }

    public Employee updateEmployee(int id, Employee newData) {
        Optional<Employee> byId = employeeRepo.findById(id);
        if (byId.isPresent()) {//true
            Employee existing = byId.get();
            existing.setName(newData.getName());
            existing.setSalary(newData.getSalary());
            existing.setDepartment(newData.getDepartment());
            return employeeRepo.save(existing);
        } else {
            throw new RuntimeException("Employee not found with id " + id);
        }
    }

    //id data yrs else return id not found

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
