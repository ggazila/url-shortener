package com.example.urlshortener.service.impl;

import com.example.urlshortener.dto.ShortUrlDto;
import com.example.urlshortener.entity.ShortenedUrl;
import com.example.urlshortener.repository.ShortenUrlRepository;
import com.example.urlshortener.service.ShortenUrlService;
import com.example.urlshortener.utils.RandomIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShortenUrlServiceImpl implements ShortenUrlService {
    private final ShortenUrlRepository shortenUrlRepository;

    @Override
    public String shortenUrl(ShortUrlDto shortUrlDto) {
        ShortenedUrl shortenedUrl = new ShortenedUrl();
        shortenedUrl.setId(RandomIdGenerator.getUniqueId());
        shortenedUrl.setTitle(shortUrlDto.getTitle());
        shortenedUrl.setOriginalUrl(shortUrlDto.getUrl());
        ShortenedUrl save = shortenUrlRepository.save(shortenedUrl);

        return save.getId();
    }

    @Override
    public Optional<ShortenedUrl> getSourceUrl(String shortenUrlId) {
        return shortenUrlRepository.findById(shortenUrlId);
    }
}
