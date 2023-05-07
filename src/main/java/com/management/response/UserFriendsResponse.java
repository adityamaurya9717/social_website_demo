package com.management.response;


import com.management.constant.Gender;
import lombok.*;



@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFriendsResponse {
    Long id;

    String email;

    String firstName;

    String lastName;

    String phoneNumber;

    boolean isphoneVerified;

    Gender gender;

    boolean active;

    String imageUrl;

}
