package com.example.review_movie.repository;

import com.example.review_movie.entity.RolePageActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePageActionRepository extends JpaRepository<RolePageActionEntity,Long> {

    RolePageActionEntity findByRoleIdAndPageIdAndActionId(long roleId, long pageId, long actionId);
}
