package com.kuroshan.ms.azureappconfig.dao.impl;

import com.kuroshan.ms.azureappconfig.config.AppConfigProperties;
import com.kuroshan.ms.azureappconfig.config.AppCustomProperties;
import com.kuroshan.ms.azureappconfig.dao.EmployeeDao;
import com.kuroshan.ms.azureappconfig.dao.mappers.EmployeeRowMapper;
import com.kuroshan.ms.azureappconfig.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

  @Autowired
  private AppCustomProperties properties;

  @Value("${custom.datasource.url}")
  private String customDataSourceUrl;

  @Value("${custom.datasource.username}")
  private String customDataSourceUserName;

  @Value("${custom.datasource.password}")
  private String customDataSourcePassword;

  @Override
  public List<Employee> findAllCustom() {

    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
    dataSource.setUrl(properties.getDatasource().getUrl());
    dataSource.setUsername(properties.getDatasource().getUsername());
    dataSource.setPassword(properties.getDatasource().getPassword());

    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource);

    String query = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, SALARY FROM EMPLOYEES2";
    List<Employee> employees = jdbcTemplate.query(query, new EmployeeRowMapper());

    return employees;
  }

  @Override
  public List<Employee> findAllProperties() {

    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
    dataSource.setUrl(customDataSourceUrl);
    dataSource.setUsername(customDataSourceUserName);
    dataSource.setPassword(customDataSourcePassword);

    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource);

    String query = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, SALARY FROM EMPLOYEES2";
    List<Employee> employees = jdbcTemplate.query(query, new EmployeeRowMapper());

    return employees;
  }

}
