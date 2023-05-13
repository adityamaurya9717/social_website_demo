package com.management.jpa.repo;

import com.management.jpa.entity.UserTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserTrackerRepository extends JpaRepository<UserTrackerEntity,Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE user_tracker set created_on = ?1 where fk_user_id = ?2",nativeQuery = true)
    int updateLastLogin(Long currentTimeStamp,Long userId);
}
