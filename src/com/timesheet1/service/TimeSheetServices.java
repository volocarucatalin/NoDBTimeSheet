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
                timeSheetList.add(new TimeSheet(Integer.parseInt(timeSheet[0]), Integer.parseInt(timeSheet[1]),false,timeSheet[2],timeSheet[3],timeSheet[4],timeSheet[5],timeSheet[6],timeSheet[7]));

            }

        } catch (RuntimeException e) {
            throw new RuntimeException("List is done");
        } finally {
            for (TimeSheet employeeTimeSheet : timeSheetList) {
                DataBase.TIME_SHEET_TABLE.put(employeeTimeSheet.getEmployeeId(),employeeTimeSheet);
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

    }

    @Override
    public int timeSheetBalance() {
        return 0;
    }
}
