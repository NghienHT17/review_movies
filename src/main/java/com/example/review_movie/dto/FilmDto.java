package com.example.review_movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmDto {
        private Long movie_id;
        private String title;
        private String plot;
        private String poster;
        private String realease_date;
        private String imdb_id;
}
