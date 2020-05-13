package com.kuroshan.ms.azureappconfig.services.impl;


import com.kuroshan.ms.azureappconfig.dao.EmployeeDao;
import com.kuroshan.ms.azureappconfig.models.Employee;
import com.kuroshan.ms.azureappconfig.repositories.EmployeeRepository;
import com.kuroshan.ms.azureappconfig.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllCustom() {
        return employeeDao.findAllCustom();
    }

    @Override
    public List<Employee> findAllProperties() {
        return employeeDao.findAllProperties();
    }

}
