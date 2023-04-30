package com.management.request;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.management.jpa.entity.DepartMentDesignation} entity
 */
public class DepartMentDesignationRequest implements Serializable {
    private Integer id;
    private Integer departmentId;
    private Integer designationId;

    public DepartMentDesignationRequest() {
    }

    public DepartMentDesignationRequest(Integer id, Integer departmentId, Integer designationId) {
        this.id = id;
        this.departmentId = departmentId;
        this.designationId = designationId;
    }

    public Integer getId() {
        return id;
    }

    public DepartMentDesignationRequest setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public DepartMentDesignationRequest setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public Integer getDesignationId() {
        return designationId;
    }

    public DepartMentDesignationRequest setDesignationId(Integer designationId) {
        this.designationId = designationId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartMentDesignationRequest entity = (DepartMentDesignationRequest) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.departmentId, entity.departmentId) &&
                Objects.equals(this.designationId, entity.designationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId, designationId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "departmentId = " + departmentId + ", " +
                "designationId = " + designationId + ")";
    }
}