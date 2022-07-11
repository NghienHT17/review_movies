package com.example.review_movie.service.Impl;

import com.example.review_movie.entity.MovieEntity;
import com.example.review_movie.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Override
    public Page<MovieEntity> getAllMovie(int page) {
        return null;
    }
}
