package com.management.jpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "friend_request")
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "from_user_id",updatable = false)
    Long fromUserId;

    @Column(name = "to_user_id",updatable = false)
    Long toUserId;

    @Column(name = "is_accepted")
    Boolean accepted;





}
