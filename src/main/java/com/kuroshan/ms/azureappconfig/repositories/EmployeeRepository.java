package com.kuroshan.ms.azureappconfig.repositories;

import com.kuroshan.ms.azureappconfig.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
