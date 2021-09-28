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


    public void createEmployee(int id, String firstName, String lastName, Role role, int amount, int iBan) {
        Employee employee = new Employee(id, firstName, lastName, role, amount, iBan);

        if (DataBase.EMPLOYEE_TABLE.containsKey(employee.getId())) {
            System.out.println("Employee already exist");
        }
        DataBase.EMPLOYEE_TABLE.put(employee.getId(), employee);
    }

    public void readeEmployeesFromClient() throws IOException {
        File file = new File("D:\\Work Place\\timesheet1\\NoDBTimeSheet\\src\\Client.txt");
        List<Employee> employeeList = new ArrayList<>();

        Scanner scanner = new Scanner(new FileReader(file));

        String line;
        try {
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                String[] employee = line.split(" ");
                employeeList.add(new Employee(Integer.parseInt(employee[0]), employee[1], employee[2], Role.valueOf(employee[3]), Integer.parseInt(employee[4]), Integer.parseInt(employee[5])));

            }

        } catch (RuntimeException e) {
            throw new RuntimeException("List is done");
        } finally {
            for (Employee employee : employeeList) {
                DataBase.EMPLOYEE_TABLE.put(employee.getId(), employee);
            }

        }


    }

    @Override
    public void addBalanceToEmployee(int employeeId , int balance) {
        Collection<Employee> employees = DataBase.EMPLOYEE_TABLE.values();
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                int oldBalance = employee.getAmount();
                employee.setAmount(oldBalance + balance);
                System.out.println("The new balance of the employee is " + employee.getAmount());
            }
        }

    }

    @Override
    public void getAllEmployee() {
        Collection<Employee> employees = DataBase.EMPLOYEE_TABLE.values();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }


    @Override
    public Employee getEmployeeById(int id) {
        Collection<Employee> employees = DataBase.EMPLOYEE_TABLE.values();
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println(employee);
                return employee;
            }
        }
        System.out.println("The employee is not in the list");
        return null;

    }
}
