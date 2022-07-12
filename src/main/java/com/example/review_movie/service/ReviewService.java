package com.example.review_movie.service;

import com.example.review_movie.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewService extends JpaRepository<ReviewEntity, Long> {

}
