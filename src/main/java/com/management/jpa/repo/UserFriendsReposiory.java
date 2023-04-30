package com.management.jpa.repo;

import com.management.jpa.entity.UserFriendsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFriendsReposiory extends JpaRepository<UserFriendsEntity,Long> {


    @Modifying
    @Query(value = "update user_friends set is_accepted = 1 where userId = ?1 and  friendUserId = ?2 ",nativeQuery = true)
    int updateFriendRequest(Long userId,Long friendId);
}
