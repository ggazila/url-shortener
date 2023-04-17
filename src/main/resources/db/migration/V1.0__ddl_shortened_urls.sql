CREATE TABLE shortened_urls
(
    id           VARCHAR(255) PRIMARY KEY UNIQUE,
    original_url VARCHAR(255) NOT NULL,
    title        VARCHAR(255),
    created_at   TIMESTAMP
);
