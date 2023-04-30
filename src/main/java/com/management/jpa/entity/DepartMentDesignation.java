package com.management.jpa.entity;


import javax.persistence.*;

@Entity
@Table(name = "designation_department")
public class DepartMentDesignation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "designation_id")
    private Integer designationId;

    @Column(name = "department_id")
    private Integer  departmentId;


    public Integer getId() {
        return id;
    }

    public DepartMentDesignation setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public DepartMentDesignation setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public Integer getDesignationId() {
        return designationId;
    }

    public DepartMentDesignation setDesignationId(Integer designationId) {
        this.designationId = designationId;
        return this;
    }

    @Override
    public String toString() {
        return "DepartMentDesignation{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", designationId=" + designationId +
                '}';
    }
}
