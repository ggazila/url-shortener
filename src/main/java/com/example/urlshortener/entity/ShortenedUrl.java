package com.example.urlshortener.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "shortened_urls")
public class ShortenedUrl {
    @Id
    private String id;
    private String title;
    private String originalUrl;
    private LocalDateTime createdAt = LocalDateTime.now();
}
