package com.kuroshan.ms.azureappconfig.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "EMPLOYEES2", schema = "HR", catalog = "")
public class Employee {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private long employeeId;

    @Basic
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Basic
    @Column(name = "LAST_NAME")
    private String lastName;

    @Basic
    @Column(name = "EMAIL")
    private String email;

    @Basic
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Basic
    @Column(name = "SALARY")
    private BigDecimal salary;

}
