package com.timesheet1.entity;

import java.util.Objects;

public class TimeSheet {

    private Employee employee;
    private int numberOfDays;
    private boolean approved;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;

    public TimeSheet(Employee employee, int numberOfDays, boolean approved, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday) {
        this.employee = employee;
        this.numberOfDays = numberOfDays;
        this.approved = approved;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeSheet)) return false;
        TimeSheet timeSheet = (TimeSheet) o;
        return getNumberOfDays() == timeSheet.getNumberOfDays() && isApproved() == timeSheet.isApproved() && Objects.equals(getEmployee(), timeSheet.getEmployee()) && Objects.equals(getMonday(), timeSheet.getMonday()) && Objects.equals(getTuesday(), timeSheet.getTuesday()) && Objects.equals(getWednesday(), timeSheet.getWednesday()) && Objects.equals(getThursday(), timeSheet.getThursday()) && Objects.equals(getFriday(), timeSheet.getFriday()) && Objects.equals(getSaturday(), timeSheet.getSaturday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployee(), getNumberOfDays(), isApproved(), getMonday(), getTuesday(), getWednesday(), getThursday(), getFriday(), getSaturday());
    }
}
