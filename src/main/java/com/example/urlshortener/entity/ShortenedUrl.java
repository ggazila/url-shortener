package com.example.urlshortener.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Data
@RedisHash("shortened_url")
public class ShortenedUrl {
    @Id
    private String id;
    private String title;
    private String originalUrl;
    private LocalDateTime createdAt = LocalDateTime.now();
}
