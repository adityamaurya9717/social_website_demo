package com.management.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "leave_type")
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "leave_type")
    private String leaveType;

    @Column(name = "total_leave")
    private Integer totalLeave;

    public Integer getId() {
        return id;
    }

    public LeaveType setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public LeaveType setLeaveType(String leaveType) {
        this.leaveType = leaveType;
        return this;
    }

    public Integer getTotalLeave() {
        return totalLeave;
    }

    public LeaveType setTotalLeave(Integer totalLeave) {
        this.totalLeave = totalLeave;
        return this;
    }

    @Override
    public String toString() {
        return "LeaveType{" +
                "id=" + id +
                ", leaveType='" + leaveType + '\'' +
                ", totalLeave=" + totalLeave +
                '}';
    }
}
