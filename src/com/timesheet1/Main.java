package com.timesheet1;

import com.timesheet1.service.EmployeeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        EmployeeService employeeService = new EmployeeService();
        Service service = new Service(employeeService);
        service.listOfOptions();
        //employeeService.readFromClient();

    }
}
