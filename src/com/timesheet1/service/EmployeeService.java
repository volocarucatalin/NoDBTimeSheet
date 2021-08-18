package com.timesheet1.service;

import com.timesheet1.DataBase.DataBase;
import com.timesheet1.entity.Employee;
import com.timesheet1.repository.EmployeeRepository;
import com.timesheet1.repository.Role;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;

public class EmployeeService implements EmployeeRepository {


    @Override
    public void createEmployee(int id, String firstName, String lastName, Role role, int amount, int iBan) {
        Employee employee = new Employee(id,firstName,lastName,role,amount,iBan);

        if(DataBase.EMPLOYEE_TABLE.containsKey(employee.getId())){
            System.out.println("Employee already exist");
        }
        DataBase.EMPLOYEE_TABLE.put(employee.getId(),employee);
    }

    public void readFromClient() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id ;
        String firstName;
        String lastName;
        Role role;
        int amount;
        int iBan;

        System.out.println("Please add your id:");
        id = Integer.parseInt(reader.readLine());
        System.out.println("Please enter your first name:");
        firstName = reader.readLine();
        System.out.println("Please enter your last name:");
        lastName= reader.readLine();
        System.out.println("Please add the role you have they can be  Worker/Supervisor/Manager:");
        role = Role.valueOf(reader.readLine());
        System.out.println("Please add your amount");
        amount = Integer.parseInt(reader.readLine());
        System.out.println("Please add your iBan ex(99999 > iBan < 999999)");
        iBan = Integer.parseInt(reader.readLine());

        createEmployee(id,firstName,lastName,role,amount,iBan);
    }

    @Override
    public void addBalanceToEmployee() {

    }

    @Override
    public void getAllEmployee() {
       Collection<Employee> employees = DataBase.EMPLOYEE_TABLE.values();
        for (Employee employee:employees) {
            System.out.println(employee.toString());
        }
    }


    @Override
    public Employee getEmployeeById(int id) {
        return null;
    }
}
