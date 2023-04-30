package com.management.request;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * A DTO for the {@link com.management.jpa.entity.Employee} entity
 */
public class EmployeeRequest implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String imageLink;
    private Integer reportsTo;
    private Integer hisHREmployeeId;
    private String joiningDate;
    private String houseAddress;
    private String state;
    private String country;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean status = true;

    public EmployeeRequest() {
    }

    public EmployeeRequest(Integer id, String firstName, String lastName, String imageLink, Integer reportsTo, Integer hisHREmployeeId, String joiningDate, String houseAddress, String state, String country, Timestamp createdAt, Timestamp updatedAt, Boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageLink = imageLink;
        this.reportsTo = reportsTo;
        this.hisHREmployeeId = hisHREmployeeId;
        this.joiningDate = joiningDate;
        this.houseAddress = houseAddress;
        this.state = state;
        this.country = country;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public EmployeeRequest setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getImageLink() {
        return imageLink;
    }

    public EmployeeRequest setImageLink(String imageLink) {
        this.imageLink = imageLink;
        return this;
    }

    public Integer getReportsTo() {
        return reportsTo;
    }

    public EmployeeRequest setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
        return this;
    }

    public Integer getHisHREmployeeId() {
        return hisHREmployeeId;
    }

    public EmployeeRequest setHisHREmployeeId(Integer hisHREmployeeId) {
        this.hisHREmployeeId = hisHREmployeeId;
        return this;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public EmployeeRequest setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
        return this;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public EmployeeRequest setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
        return this;
    }

    public String getState() {
        return state;
    }

    public EmployeeRequest setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public EmployeeRequest setCountry(String country) {
        this.country = country;
        return this;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public EmployeeRequest setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public EmployeeRequest setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Boolean getStatus() {
        return status;
    }

    public EmployeeRequest setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeRequest entity = (EmployeeRequest) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.imageLink, entity.imageLink) &&
                Objects.equals(this.reportsTo, entity.reportsTo) &&
                Objects.equals(this.hisHREmployeeId, entity.hisHREmployeeId) &&
                Objects.equals(this.joiningDate, entity.joiningDate) &&
                Objects.equals(this.houseAddress, entity.houseAddress) &&
                Objects.equals(this.state, entity.state) &&
                Objects.equals(this.country, entity.country) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedAt, entity.updatedAt) &&
                Objects.equals(this.status, entity.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, imageLink, reportsTo, hisHREmployeeId, joiningDate, houseAddress, state, country, createdAt, updatedAt, status);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "imageLink = " + imageLink + ", " +
                "reportsTo = " + reportsTo + ", " +
                "hisHREmployeeId = " + hisHREmployeeId + ", " +
                "joiningDate = " + joiningDate + ", " +
                "houseAddress = " + houseAddress + ", " +
                "state = " + state + ", " +
                "country = " + country + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ", " +
                "status = " + status + ")";
    }
}