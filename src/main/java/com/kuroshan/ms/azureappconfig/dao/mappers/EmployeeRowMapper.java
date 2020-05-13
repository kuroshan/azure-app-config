package com.kuroshan.ms.azureappconfig.dao.mappers;

import com.kuroshan.ms.azureappconfig.models.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

  @Override
  public Employee mapRow(ResultSet rs, int i) throws SQLException {
    return Employee
        .builder()
        .employeeId(rs.getLong("EMPLOYEE_ID"))
        .firstName(rs.getString("FIRST_NAME"))
        .lastName(rs.getString("LAST_NAME"))
        .email(rs.getString("EMAIL"))
        .phoneNumber(rs.getString("PHONE_NUMBER"))
        .salary(rs.getBigDecimal("SALARY"))
        .build();
  }
}
