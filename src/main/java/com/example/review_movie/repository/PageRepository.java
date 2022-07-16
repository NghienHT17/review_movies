package com.example.review_movie.repository;

import com.example.review_movie.entity.PageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<PageEntity, Long> {

    PageEntity findByUrl(String url);

}
