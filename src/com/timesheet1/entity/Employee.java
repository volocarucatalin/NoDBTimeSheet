package com.timesheet1.entity;

import com.timesheet1.util.Role;

import java.io.Serializable;
import java.util.Objects;

public class Employee  implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private Role role;
    private int amount;
    private int iBan;

    public Employee(int id, String firstName, String lastName, Role role, int amount, int iBan) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.amount = amount;
        this.iBan = iBan;
    }

    public Employee() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getIBan() {
        return iBan;
    }

    public void setIBan(int iBan) {
        this.iBan = iBan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && getAmount() == employee.getAmount() && iBan == employee.iBan && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && getRole() == employee.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getRole(), getAmount(), iBan);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", amount=" + amount +
                ", iBan=" + iBan +
                '}';
    }
}
