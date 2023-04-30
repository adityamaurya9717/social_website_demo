package com.management.jpa.repo;

import com.management.jpa.entity.UserAddressEntity;
import com.management.mongodocument.user.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddressEntity,Integer> {
}
