package com.management.jpa.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "employee_leaves")
public class EmployeeLeaves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "`from`")
    private Timestamp from;

    @Column(name = "`to`")
    private Timestamp to;

    @Column(name = "count")
    private  Integer count;
    @Column(name = "is_approved")
    private boolean isApproved = false;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = LeaveType.class)
    @JoinColumn(name = "leave_type_id")
    private LeaveType leaveType;

    public Integer getId() {
        return id;
    }

    public EmployeeLeaves setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public EmployeeLeaves setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Timestamp getFrom() {
        return from;
    }

    public EmployeeLeaves setFrom(Timestamp from) {
        this.from = from;
        return this;
    }

    public Timestamp getTo() {
        return to;
    }

    public EmployeeLeaves setTo(Timestamp to) {
        this.to = to;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public EmployeeLeaves setCount(Integer count) {
        this.count = count;
        return this;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public EmployeeLeaves setApproved(boolean approved) {
        isApproved = approved;
        return this;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }
}
