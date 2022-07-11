package com.example.review_movie.service;

import com.example.review_movie.entity.MovieEntity;
import org.springframework.data.domain.Page;

public interface MovieService {
    Page<MovieEntity> getAllMovie(int page);
}
