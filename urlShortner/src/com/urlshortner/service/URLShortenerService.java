package com.urlshortner.service;

import com.urlshortner.hash.HashGenerator;
import com.urlshortner.repo.URLRepository;

public class URLShortenerService {

    private URLRepository urlRepository;
    private HashGenerator hashGenerator;

    private static final String BASE_URL = "http://short.ly";

    public URLShortenerService(URLRepository urlRepository, HashGenerator hashGenerator) {
        this.urlRepository = urlRepository;
        this.hashGenerator = hashGenerator;
    }

    public String generateShortUrl(String longUrl) {
        String hash = hashGenerator.generateHashcode(longUrl);
        String shortUrl = BASE_URL + "/" + hash;
        urlRepository.saveUrl(shortUrl, longUrl);
        return shortUrl;
    }

    public String getLongUrl(String shortUrl) {
        return urlRepository.getLongUrl(shortUrl);
    }
}
