package com.management.mongodocument.user;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Document(value = "users_collection")
public class UserModel {


    @MongoId
    private String id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Field(name = "firstName")
    private String firstName;

    @Field(name = "lastName")
    private String lastName;

    @Indexed(unique = true)
    @Field(name="email")
    private String email;

    @Field(name = "isActive")
    private boolean isActive=true;

    @Field(name="dateOfBirth")
    private Date dateOfBirth;

    @Field(name="address")
    private UserAddress address;
    public String getId() {
        return id;
    }

    public UserModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public UserModel setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public UserModel setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserModel setActive(boolean active) {
        isActive = active;
        return this;
    }

    public UserAddress getAddress() {
        return address;
    }

    public UserModel setAddress(UserAddress address) {
        this.address = address;
        return this;
    }

    public UserModel() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
