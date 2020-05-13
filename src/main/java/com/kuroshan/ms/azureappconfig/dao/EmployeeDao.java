package com.kuroshan.ms.azureappconfig.dao;

import com.kuroshan.ms.azureappconfig.models.Employee;

import java.util.List;

public interface EmployeeDao {

  public List<Employee> findAllCustom();

  public List<Employee> findAllProperties();

}
