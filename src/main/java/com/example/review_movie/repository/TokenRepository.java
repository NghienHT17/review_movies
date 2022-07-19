package com.example.review_movie.repository;

import com.example.review_movie.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity,Long> {
    TokenEntity findByToken(String token);
}
