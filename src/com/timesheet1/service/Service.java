package com.timesheet1.service;

import com.timesheet1.service.EmployeeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class  Service {
    private final EmployeeService employeeService;

    public Service(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    int i;
    BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));

    public void listOfOptions() throws IOException {
        System.out.println("Create a new Employee please enter number (1)");
        System.out.println("Do you want to add a new balance to a Employee please enter number(2)");
        System.out.println("Do you want to se all the Employees please enter number(3) ");
        System.out.println("Do you want to find one employee please enter number(4)");
        System.out.println("If you want to exit please press (0)");
         i = Integer.parseInt(bufferedReader.readLine());
         readUserResponse(i);
    }

    public void readUserResponse(Integer i) throws IOException {
        if( i == null){
            System.out.println("Invalid number");
        }
        switch (i){
            case 0 :
                System.out.println("You exit the menu");
                break;
            case 1 :
                employeeService.readeEmployeesFromClient();
                System.out.println("You add your employee");
                listOfOptions();
                break;
            case 2:
                System.out.println("Please ID and the new balance Balance");
                int employeeId = Integer.parseInt(bufferedReader.readLine());
                int balance = Integer.parseInt(bufferedReader.readLine());
                employeeService.addBalanceToEmployee(employeeId,balance);
                listOfOptions();
                break;
            case 3:
                employeeService.getAllEmployee();
                listOfOptions();
                break;
            case 4:
                System.out.println("Please enter user ID");
                int idNumber = Integer.parseInt(bufferedReader.readLine());
                employeeService.getEmployeeById(idNumber);
                listOfOptions();
        }
    }
}