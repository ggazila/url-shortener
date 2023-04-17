package com.example.urlshortener.service;

import com.example.urlshortener.dto.ShortUrlDto;
import com.example.urlshortener.entity.ShortenedUrl;

import java.util.Optional;

public interface ShortenUrlService {

    String shortenUrl(ShortUrlDto shortUrlDto);

    Optional<ShortenedUrl> getSourceUrl(String shortenUrlId);
}
