package com.example.review_movie.service;

import com.example.review_movie.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewService extends JpaRepository<ReviewEntity,Long> {

}
