package com.timesheet1;

import com.timesheet1.service.EmployeeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class  Service {
    private final EmployeeService employeeService;

    public Service(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public void listOfOptions() throws IOException {
        int i;
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));

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
                employeeService.readFromClient();
                System.out.println("You add your employee");
                listOfOptions();
                break;
            case 2:
                System.out.println("Not implemented");
                employeeService.addBalanceToEmployee();
                listOfOptions();
                break;
            case 3:
                employeeService.getAllEmployee();
                listOfOptions();
                break;
            case 4:
                System.out.println("Not implemented");
                employeeService.getEmployeeById(0);
                listOfOptions();
        }
    }
}
