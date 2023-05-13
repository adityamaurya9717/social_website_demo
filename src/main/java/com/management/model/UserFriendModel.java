package com.management.model;

import lombok.*;
import java.sql.Timestamp;
;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFriendModel {

    private Long id;

    private Long userId;

    private  Long friendUserId;

    private   boolean accepted = false;

    Timestamp createdAt ;
}
