package com.example.review_movie.repository;

import com.example.review_movie.entity.RoleEntity;
import com.example.review_movie.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("select u from UserEntity u where u.role = ?1")
    Page<UserEntity> findByRole(Set<RoleEntity> roleSet, Pageable of);

    UserEntity findByUserId(long id);

    UserEntity findByToken(String token);
}


