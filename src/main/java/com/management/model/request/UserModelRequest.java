package com.management.model.request;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.management.mongodocument.user.UserAddress;
import com.management.mongodocument.user.UserModel;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.util.Date;

public class UserModelRequest {


    private int userId;

    @NotBlank(message = "first name cannot be empty")
    private String firstName;

    @NotBlank(message = "last name cannot be empty")
    private String lastName;

    @Email(message = "email invalid")
    private String email;

    private boolean isActive=true;

    private Date dateOfBirth;

    public int getUserId() {
        return userId;
    }

    public UserModelRequest setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserModelRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserModelRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModelRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserModelRequest setActive(boolean active) {
        isActive = active;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public UserModelRequest setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

}
