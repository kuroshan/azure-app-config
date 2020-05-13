package com.kuroshan.ms.azureappconfig.services;

import com.kuroshan.ms.azureappconfig.models.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public List<Employee> findAllCustom();

    public List<Employee> findAllProperties();

}
