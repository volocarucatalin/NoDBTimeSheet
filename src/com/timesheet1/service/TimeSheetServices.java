package com.timesheet1.service;

import com.timesheet1.DataBase.DataBase;
import com.timesheet1.entity.Employee;
import com.timesheet1.entity.TimeSheet;
import com.timesheet1.repository.TimeSheetRepository;
import com.timesheet1.util.Role;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class TimeSheetServices implements TimeSheetRepository {
    @Override
    public void readAllTimeSheet() throws FileNotFoundException {
        File file = new File("D:\\Work Place\\timesheet1\\NoDBTimeSheet\\src\\TimeSheet.txt");
        List<TimeSheet> timeSheetList = new ArrayList<>();

        Scanner scanner = new Scanner(new FileReader(file));

        String line;
        try {
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                String[] timeSheet = line.split(" ");
                timeSheetList.add(new TimeSheet(Integer.parseInt(timeSheet[0]), Integer.parseInt(timeSheet[1]), false, timeSheet[2], timeSheet[3], timeSheet[4], timeSheet[5], timeSheet[6], timeSheet[7]));

            }

        } catch (RuntimeException e) {
            throw new RuntimeException("List is done");
        } finally {
            for (TimeSheet employeeTimeSheet : timeSheetList) {
                DataBase.TIME_SHEET_TABLE.put(employeeTimeSheet.getEmployeeId(), employeeTimeSheet);
            }

        }

    }

    @Override
    public void showAllTimeSheet() {
        Collection<TimeSheet> timeSheets = DataBase.TIME_SHEET_TABLE.values();
        for (TimeSheet timeSheet : timeSheets) {
            System.out.println(timeSheet.toString());
        }
    }

    @Override
    public void timeSheetApproval() {
        String firstName;
        int iBan;
        String approval;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Your Name and Iban");
        firstName = scanner.nextLine();
        iBan = Integer.parseInt(scanner.nextLine());

        Collection<Employee> employees = DataBase.EMPLOYEE_TABLE.values();
        for (Employee employee : employees) {
            if (employee.getIBan() == iBan && employee.getFirstName().equals(firstName)) {
                System.out.println(employee);
                if (employee.getRole().equals(Role.MANAGER) || employee.getRole().equals(Role.SUPERVISOR)) {
                    System.out.println("Having a role of a Supervisor or Manager you are able to approve the TimeSheets ");
                    Collection<TimeSheet> timeSheets = DataBase.TIME_SHEET_TABLE.values();
                    for (TimeSheet timeSheet : timeSheets) {
                        System.out.println(timeSheet);
                        System.out.println("Please enter 'Approve' or 'Not Approve'");
                        approval = scanner.nextLine();
                        if (approval.equals("Approve")) {
                            timeSheet.setApproved(true);
                        }
                    }
                } else {
                    System.out.println("You cant Approve the TimeSheet you are not a Supervisor or Manager ");
                }

            }
        }
        System.out.println("The employee is not in the list");
    }


    @Override
    public int timeSheetBalance() {
        final int supervisorDayRate = 160;
        final int managerDayRate = 250;
        final int workerDayRate = 130;
        int newBalance = 0;
        Collection<TimeSheet> timeSheets = DataBase.TIME_SHEET_TABLE.values();
        for (TimeSheet timeSheet : timeSheets) {
            if (timeSheet.isApproved()) {
                Collection<Employee> employees = DataBase.EMPLOYEE_TABLE.values();
                for (Employee employee : employees) {
                    if (employee.getId() == timeSheet.getEmployeeId()) {
                        if (employee.getRole().equals(Role.WORKER)) {
                            newBalance = timeSheet.getNumberOfDays() * workerDayRate;
                            System.out.println("The Time Sheet balance is :");
                            return   newBalance;
                        }
                        if (employee.getRole().equals(Role.SUPERVISOR)) {
                            newBalance = timeSheet.getNumberOfDays() * supervisorDayRate;
                            System.out.println("The Time Sheet balance is :");
                            return   newBalance;
                        }
                        if (employee.getRole().equals(Role.MANAGER)) {
                            newBalance = timeSheet.getNumberOfDays() * managerDayRate;
                            System.out.println("The Time Sheet balance is :");
                            return   newBalance;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
