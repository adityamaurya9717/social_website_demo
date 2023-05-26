package com.management.jpa.repo;

import com.management.jpa.entity.UserEntity;
import com.management.jpa.entity.UserFriendsEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserFriendsReposiory extends PagingAndSortingRepository<UserFriendsEntity,Long> {

    @Transactional
    @Modifying
    @Query(value = "update user_friends set is_accepted = 1 where userId = ?1 and  friendUserId = ?2 ",nativeQuery = true)
    int updateFriendRequest(Long userId,Long friendId);

    @Query(value = "select friend_user_id from user_friends where user_id = ?1",nativeQuery = true)
    List<Long> getUserFriendsIds(Long userId);

    @Query(" SELECT u FROM UserFriendsEntity u where u.userId = ?1")
    List<UserFriendsEntity> getUsersFriends(Long userId);

   // @Query(value = "SELECT U FROM UserFriendsEntity u where u.id in (:ids)")
    List<UserFriendsEntity> findByIdIn(@Param("ids") List<Long> integers, Pageable pageable);


}
