package com.kuroshan.ms.azureappconfig.controllers;

import com.kuroshan.ms.azureappconfig.models.Employee;
import com.kuroshan.ms.azureappconfig.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> listEmployees() {
        return new ResponseEntity<List<Employee>>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/custom", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> listEmployeesCustom() {
        return new ResponseEntity<List<Employee>>(employeeService.findAllCustom(), HttpStatus.OK);
    }

    @GetMapping(value = "/properties", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> listEmployeesProperties() {
        return new ResponseEntity<List<Employee>>(employeeService.findAllProperties(), HttpStatus.OK);
    }

}
