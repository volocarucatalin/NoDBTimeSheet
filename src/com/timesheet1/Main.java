package com.timesheet1;

import com.timesheet1.service.EmployeeService;
import com.timesheet1.service.Service;
import com.timesheet1.service.TimeSheetServices;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        EmployeeService employeeService = new EmployeeService();
        TimeSheetServices timeSheetServices = new TimeSheetServices();
        Service service = new Service(employeeService, timeSheetServices);
        service.listOfOptions();

    }
}
