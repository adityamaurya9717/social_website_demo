package com.management.request;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {

    @Email(message = "invalid email format")
    String email;

    @NotEmpty(message = "firstName cannot be null")
    String firstName;

    @NotEmpty(message = "lastName cannot be empty")
    String lastName;

    @NotEmpty(message = "phone number cannot be null")
    String phoneNumber;

}
