package com.timesheet1.repository;

import java.io.FileNotFoundException;

public interface TimeSheetRepository {

    void readAllTimeSheet() throws FileNotFoundException;
    void showAllTimeSheet();
    void timeSheetApproval();
    int timeSheetBalance();
}
