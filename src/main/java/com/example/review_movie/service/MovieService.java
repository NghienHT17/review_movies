package com.example.review_movie.service;

import com.example.review_movie.dto.FilmDto;
import com.example.review_movie.entity.MovieEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MovieService {
    Page<MovieEntity> getAllMovie(int page);

    MovieEntity addMovie(MovieEntity movie);

    void addListMovie(List<FilmDto> listFilmDtos);
}
