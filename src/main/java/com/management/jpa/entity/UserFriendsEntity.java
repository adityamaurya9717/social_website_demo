package com.management.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_friends")
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFriendsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "friend_user_id")
    private  Long friendUserId;

    @Column(name = "is_accepted")
    private   boolean accepted = false;

    @Column(name="created_at")
    Timestamp createdAt = Timestamp.valueOf(LocalDateTime.now());

    //for insert
    public UserFriendsEntity(Long userId, Long friendUserId){
        this.userId = userId;
        this.friendUserId = friendUserId;
        this.accepted = false;
    }
}
