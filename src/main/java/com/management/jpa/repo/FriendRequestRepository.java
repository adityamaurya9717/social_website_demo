package com.management.jpa.repo;

import com.management.jpa.entity.FriendRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRequestRepository extends JpaRepository<FriendRequestEntity,Integer> {
}
