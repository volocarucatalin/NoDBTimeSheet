package com.timesheet1.repository;

import com.timesheet1.entity.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeRepository {
    void createEmployee(int id, String firstName, String lastName, Role role, int amount, int iBan);

    void addBalanceToEmployee();

    void getAllEmployee();

    Employee getEmployeeById(int id);
}
