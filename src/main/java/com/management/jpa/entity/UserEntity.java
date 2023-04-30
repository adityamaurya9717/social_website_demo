package com.management.jpa.entity;

import com.management.request.AddUserRequest;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "email",unique = true,updatable = false,nullable = false)
    String email;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "phoneNumber")
    String phoneNumber;

    @Column(name="phone_verified")
    boolean isphoneVerified;

    @Column(name="created_at",updatable = false)
    Timestamp createdAt = Timestamp.valueOf(LocalDateTime.now());

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    UserAddressEntity userAddressEntity;

    public UserEntity(AddUserRequest request){
        this.firstName = request.getFirstName();
        this.lastName = request.getLastName();
        this.email = request.getEmail();
        this.phoneNumber = request.getPhoneNumber();
        this.isphoneVerified = false;
    }
}
