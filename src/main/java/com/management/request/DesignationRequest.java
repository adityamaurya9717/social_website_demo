package com.management.request;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.management.jpa.entity.Designation} entity
 */
public class DesignationRequest implements Serializable {
    private Integer id;
    private String designationType;

    public DesignationRequest() {
    }

    public DesignationRequest(Integer id, String designationType) {
        this.id = id;
        this.designationType = designationType;
    }

    public Integer getId() {
        return id;
    }

    public DesignationRequest setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDesignationType() {
        return designationType;
    }

    public DesignationRequest setDesignationType(String designationType) {
        this.designationType = designationType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DesignationRequest entity = (DesignationRequest) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.designationType, entity.designationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designationType);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "designationType = " + designationType + ")";
    }
}