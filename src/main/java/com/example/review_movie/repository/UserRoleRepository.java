package com.example.review_movie.repository;

import com.example.review_movie.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {
    List<UserRoleEntity> findByIdUser(long userId);
}
