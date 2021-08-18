package com.timesheet1.DataBase;

import com.timesheet1.entity.Employee;
import com.timesheet1.entity.TimeSheet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataBase {
    public static final Map<Integer, Employee> EMPLOYEE_TABLE = new ConcurrentHashMap<>();
    public static final Map<Integer, TimeSheet> TIME_SHEET_TABLE = new ConcurrentHashMap<>();
}
