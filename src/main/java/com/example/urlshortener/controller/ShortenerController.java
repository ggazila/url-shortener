package com.example.urlshortener.controller;

import com.example.urlshortener.dto.ShortUrlDto;
import com.example.urlshortener.entity.ShortenedUrl;
import com.example.urlshortener.service.ShortenUrlService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("api/short")
@RequiredArgsConstructor
public class ShortenerController {
    private final ShortenUrlService shortenUrlService;

    @PostMapping
    public ResponseEntity<Object> shortenUrl(@RequestBody ShortUrlDto shortUrlDto) {
        String uniqueId = shortenUrlService.shortenUrl(shortUrlDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(uniqueId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("{shortenUrlId}")
    public String redirectToSourceUrl(@PathVariable String shortenUrlId, HttpServletResponse response) throws IOException {
        Optional<ShortenedUrl> sourceUrl = shortenUrlService.getSourceUrl(shortenUrlId);
        if (sourceUrl.isPresent()) {
            response.sendRedirect(sourceUrl.get().getOriginalUrl());
        }
        return "This is a virus, heheheheeh!!!!";
    }

}
