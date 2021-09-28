package com.timesheet1;

import com.timesheet1.service.EmployeeService;
import com.timesheet1.service.Service;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        EmployeeService employeeService = new EmployeeService();
        Service service = new Service(employeeService);
        service.listOfOptions();
        //employeeService.readFromClient();

    }
}
