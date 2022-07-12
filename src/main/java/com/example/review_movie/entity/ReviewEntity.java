package com.example.review_movie.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "review")
@Getter
@Setter
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column(name = "review_text")
    private String reviewText;

    @Column(name = "star")
    private int star;

//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private UserEntity user;

    @Column(name = "user_id")
    private long userId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

}
