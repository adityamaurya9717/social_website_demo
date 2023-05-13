package com.management.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


/*
  tracking user last_login detail so its use
   to send email regarding new Friend request
   total followers

 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_tracker")
@EntityListeners({AuditingEntityListener.class})
public class UserTrackerEntity implements Serializable {

    @Id
    @Column(name = "fk_user_id",updatable = false) // primary key from user table (UserEntity)
    private Long userId;

    @Column(name="email",unique = true,updatable = false) // not updatable
    private String email;

    @Column(name = "total_followers")
    private Long totalFollowers;

    @Column(name="created_on",updatable = false)
    private Long createdOn;

    @Column(name="last_online")
    private Long lastOnline;

    @Column(name = "blue_check") //  to identify whether a user is celebrity or not    this is updatable
    private boolean blueCheck;

    @BatchSize(size = 100)
    @OneToMany(fetch = FetchType.LAZY,targetEntity = UserFollowerEntity.class)
    @JoinColumn(referencedColumnName = "fk_user_id")
    private Set<UserFollowerEntity> userFollowers;



}
