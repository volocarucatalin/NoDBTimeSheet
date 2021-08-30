package com.timesheet1.service;

import com.timesheet1.DataBase.DataBase;
import com.timesheet1.entity.Employee;
import com.timesheet1.repository.EmployeeRepository;
import com.timesheet1.repository.Role;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements EmployeeRepository {


    @Override
    public void createEmployee(int id, String firstName, String lastName, Role role, int amount, int iBan) {
        Employee employee = new Employee(id, firstName, lastName, role, amount, iBan);

        if (DataBase.EMPLOYEE_TABLE.containsKey(employee.getId())) {
            System.out.println("Employee already exist");
        }
        DataBase.EMPLOYEE_TABLE.put(employee.getId(), employee);
    }

    public void readFromClient() throws IOException {
        File file = new File("D:\\Work Place\\timesheet1\\NoDBTimeSheet\\src\\Client.txt");
        List<Employee> employeeList = new ArrayList<>();

        Scanner scanner = new Scanner(new FileReader(file));

        String line;
        try {
            while ((line = scanner.nextLine()) != null) {
                Employee employee = new Employee(Integer.parseInt(scanner.next()), scanner.next(), scanner.next(), Role.valueOf(scanner.next()), Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()));
                employeeList.add(employee);
            }

        }catch (RuntimeException e){
            throw new RuntimeException("List is done");
        }finally {
            for (Employee employee : employeeList) {
                DataBase.EMPLOYEE_TABLE.put(employee.getId(), employee);
            }

        }


    }

        @Override
        public void addBalanceToEmployee () {

        }

        @Override
        public void getAllEmployee () {
            Collection<Employee> employees = DataBase.EMPLOYEE_TABLE.values();
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        }


        @Override
        public Employee getEmployeeById ( int id){
            return null;
        }
    }
