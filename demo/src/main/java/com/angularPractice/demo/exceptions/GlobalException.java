package com.angularPractice.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleNotoundException(EmployeeNotFoundException employeeNotFoundException){
        Map<String, Object> body= new HashMap<>();
        body.put("Message",employeeNotFoundException.getMessage());
        body.put("Status", 404);
        body.put("Timestamp", LocalDate.now());
        return new ResponseEntity(body,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> globalexception(Exception e){
        Map<String, Object> body= new LinkedHashMap<>();
        body.put("Message",e.getMessage());
        body.put("Status", 505);
        body.put("Timestamp", LocalDate.now());
        return new ResponseEntity(body,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
