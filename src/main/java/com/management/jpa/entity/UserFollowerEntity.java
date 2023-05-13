package com.management.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_followers")
public class UserFollowerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "user_id")
    Long userId;
    @Column(name = "follower_user_id")
    Long followerUserId;
    @Column(name = "created_on")
    Long createdOn;

    @PrePersist
    public void checKUserIdNotSame(){
        if(this.followerUserId==this.userId){
            throw new RuntimeException("follower userID is not follow itself");
        }
        this.createdOn = this.createdOn==null?System.currentTimeMillis():this.createdOn;
    }

}
