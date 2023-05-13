package com.management.model;

import com.management.constant.Gender;
import com.management.jpa.entity.UserAddressEntity;
import com.management.jpa.entity.UserFriendsEntity;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    Long id;

    String email;

    String firstName;

    String lastName;

    String phoneNumber;

    boolean isphoneVerified;

    Gender gender;

    boolean active;

    String imageUrl;

    Timestamp createdAt ;

    UserAddressEntity userAddressEntity;

    List<UserFriendModel> userFriendsEntity;
}
