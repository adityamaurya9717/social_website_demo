package com.management.jpa.entity;

import org.hibernate.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "department_name")
    private String departmentName;

    public Integer getId() {
        return id;
    }

    public Department setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Department setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }
}
