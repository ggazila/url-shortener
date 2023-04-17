package com.example.urlshortener.repository;

import com.example.urlshortener.entity.ShortenedUrl;
import org.springframework.data.repository.CrudRepository;

public interface ShortenUrlRepository extends CrudRepository<ShortenedUrl, String> {
}
