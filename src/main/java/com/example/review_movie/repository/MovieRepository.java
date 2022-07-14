package com.example.review_movie.repository;

import com.example.review_movie.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    @Query("select m from MovieEntity m")
    List<MovieEntity> findAll();
}
