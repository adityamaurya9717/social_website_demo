package com.management.jpa.repo;

import com.management.jpa.entity.DepartMentDesignation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartMentDesignationRepository extends JpaRepository<DepartMentDesignation, Integer>, JpaSpecificationExecutor<DepartMentDesignation> {
}