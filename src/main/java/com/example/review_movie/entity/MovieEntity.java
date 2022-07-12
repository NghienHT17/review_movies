package com.example.review_movie.entity;

import lombok.Getter;
import lombok.Setter;
//import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter

public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long movieId;

    @Column(name = "name")
    private String movieName;

    @Column(name = "tittle")
    private String tittle;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "description")
    private String description;

    @Column(name = "poster")
    private String posterLink;

    @Transient
//    @JsonIgnore
    private List<CasterEntity> listCaster;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<ReviewEntity> listReview;

    public MovieEntity() {
        this.movieName = movieName;
        this.tittle = tittle;
        this.description = description;
    }
}
