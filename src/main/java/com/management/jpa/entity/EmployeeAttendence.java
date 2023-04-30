package com.management.jpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "employee_attendence")
public class EmployeeAttendence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "employee_id",nullable = false)
    private Integer employeeId;

    @Column(name = "check_in")
    private Timestamp checkIn;

    @Column(name = "check_out")
    private Timestamp checkOut;

    public Integer getId() {
        return id;
    }

    public EmployeeAttendence setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public EmployeeAttendence setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Timestamp getCheckIn() {
        return checkIn;
    }

    public EmployeeAttendence setCheckIn(Timestamp checkIn) {
        this.checkIn = checkIn;
        return this;
    }

    public Timestamp getCheckOut() {
        return checkOut;
    }

    public EmployeeAttendence setCheckOut(Timestamp checkOut) {
        this.checkOut = checkOut;
        return this;
    }

    @Override
    public String toString() {
        return "EmployeeAttendence{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
