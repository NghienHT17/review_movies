package com.example.review_movie.service.Impl;

import com.example.review_movie.entity.MovieEntity;
import com.example.review_movie.repository.MovieRepository;
import com.example.review_movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Override
    public Page<MovieEntity> getAllMovie(int page) {
        return null;
    }

    @Override
    public MovieEntity addMovie(MovieEntity newMovie) {
        MovieEntity _movie = new MovieEntity();
        _movie.setMovieName(newMovie.getMovieName());
        _movie.setTittle(newMovie.getTittle());
        _movie.setDescription(newMovie.getDescription());
        return movieRepository.save(_movie) ;
    }
}
