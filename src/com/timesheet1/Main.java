package com.timesheet1;

import com.timesheet1.service.EmployeeService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        EmployeeService employeeService = new EmployeeService();
       // employeeService.readFromClient();
        employeeService.getAllEmployee();
    }
}
