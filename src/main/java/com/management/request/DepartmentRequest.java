package com.management.request;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.management.jpa.entity.Department} entity
 */
public class DepartmentRequest implements Serializable {
    private Integer id;
    private String departmentName;

    public DepartmentRequest() {
    }

    public DepartmentRequest(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public DepartmentRequest setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public DepartmentRequest setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentRequest entity = (DepartmentRequest) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.departmentName, entity.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "departmentName = " + departmentName + ")";
    }
}