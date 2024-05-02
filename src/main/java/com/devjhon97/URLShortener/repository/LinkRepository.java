package com.devjhon97.URLShortener.repository;

import com.devjhon97.URLShortener.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, String> {
}
