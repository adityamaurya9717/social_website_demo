package com.management.jpa.repo;

import com.management.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query(value = "select count(*) from user where id in (?1)",nativeQuery = true)
    Integer isUserExists(List<Long> usersIds);
}
