package com.management.jpa.repo;

import com.management.jpa.entity.UserFriendsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFriendsReposiory extends JpaRepository<UserFriendsEntity,Long> {


    @Modifying
    @Query(value = "update user_friends set is_accepted = 1 where userId = ?1 and  friendUserId = ?2 ",nativeQuery = true)
    int updateFriendRequest(Long userId,Long friendId);

    @Query(value = "select friend_user_id from user_friends where user_id = ?1",nativeQuery = true)
    List<Long> getUserFriendsIds(Long userId);
}
