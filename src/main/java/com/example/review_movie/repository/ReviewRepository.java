package com.example.review_movie.repository;

import com.example.review_movie.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    @Query("select r from ReviewEntity r where r.userId = ?1")
    List<ReviewEntity> findByUserId(long userId);
}
