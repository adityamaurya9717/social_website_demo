package com.management.jpa.repo;

import com.management.jpa.entity.UserFollowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFollowerRepository extends JpaRepository<UserFollowerEntity,Long> {
}
