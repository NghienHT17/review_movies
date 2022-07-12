package com.example.review_movie.api;

import com.example.review_movie.entity.MovieEntity;
import com.example.review_movie.service.MovieService;
import com.example.review_movie.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/movie")
public class MovieApi {

    @Autowired
    ReviewService reviewService;

    @Autowired
    MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<Page<MovieEntity>> getAllMovie(@RequestParam(defaultValue = "1") int page){
        Page<MovieEntity> listMovie = movieService.getAllMovie(page);
        return  ResponseEntity.ok(listMovie);
    }



}
