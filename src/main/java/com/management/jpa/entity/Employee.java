package com.management.jpa.entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "first_name",nullable = false)
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "image_link")
    String imageLink;

    @Column(name = "report_to")
    private Integer reportsTo;

    @Column(name = "his_hr")
    private Integer hisHREmployeeId;

    @Column(name = "joining_date")
    private String joiningDate;

    @Column(name="house_address")
    String houseAddress;

    @Column(name = "state")
    String state;

    @Column(name = "counry")
    String country;


    @Column(name = "created_at",updatable = false)
    Timestamp createdAt;
    @Column(name = "updated_at")
    Timestamp updatedAt;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = Designation.class)
    @JoinColumn(name = "designation_id")
    private Designation designation;


    @Column(name = "status")
    private Boolean status = true;

    public Integer getId() {
        return id;
    }

    public Employee setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getImageLink() {
        return imageLink;
    }

    public Employee setImageLink(String imageLink) {
        this.imageLink = imageLink;
        return this;
    }

    public Integer getReportsTo() {
        return reportsTo;
    }

    public Employee setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
        return this;
    }

    public Integer getHisHREmployeeId() {
        return hisHREmployeeId;
    }

    public Employee setHisHREmployeeId(Integer hisHREmployeeId) {
        this.hisHREmployeeId = hisHREmployeeId;
        return this;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Employee setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public Employee setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public Employee setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
        return this;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public Employee setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
        return this;
    }

    public String getState() {
        return state;
    }

    public Employee setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Employee setCountry(String country) {
        this.country = country;
        return this;
    }

    public Boolean getStatus() {
        return status;
    }

    public Employee setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public Designation getDesignation() {
        return designation;
    }

    public Employee setDesignation(Designation designation) {
        this.designation = designation;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", reportsTo=" + reportsTo +
                ", hisHREmployeeId=" + hisHREmployeeId +
                ", joiningDate='" + joiningDate + '\'' +
                ", houseAddress='" + houseAddress + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
    }
}
