package com.example.review_movie.service.Impl;

import com.example.review_movie.dto.FilmDto;
import com.example.review_movie.entity.MovieEntity;
import com.example.review_movie.repository.MovieRepository;
import com.example.review_movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public Page<MovieEntity> getAllMovie(int page) {
        return movieRepository.findAll(PageRequest.of(page -1,6));
    }

    @Override
    public void addListMovie(List<FilmDto> listFilmDtos) {
        MovieEntity _movie = new MovieEntity();
//        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
//        LocalDate date = LocalDate.parse("2018-04-10T04:00:00.000Z", inputFormatter);
//        String formattedDate = outputFormatter.format(date);
//        System.out.println(formattedDate);
        for (int i = 0; i < listFilmDtos.size(); i++) {
           FilmDto filmDto = listFilmDtos.get(i);
            System.err.println(filmDto);
            _movie.setMovieId(filmDto.getMovie_id());
            _movie.setMovieName(filmDto.getTitle());
            _movie.setDescription(filmDto.getPlot());
//            String _date = filmDto.getRealease_date().toString();
            _movie.setReleaseDate(filmDto.getRealease_date());
            _movie.setPosterLink(filmDto.getPoster());
            _movie.setImdbId(filmDto.getImdb_id());
            movieRepository.save(_movie);
        }
        return;
    }

    @Override
    public MovieEntity addMovie(MovieEntity newMovie) {
        MovieEntity _movie = new MovieEntity();
        _movie.setMovieName(newMovie.getMovieName());
        _movie.setDescription(newMovie.getDescription());
        return movieRepository.save(_movie);
    }
}
