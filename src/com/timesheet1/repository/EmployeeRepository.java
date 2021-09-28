package com.timesheet1.repository;

import com.timesheet1.entity.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeRepository {



    void addBalanceToEmployee(int employeeId,int balance);

    void getAllEmployee();

    Employee getEmployeeById(int id);
}
