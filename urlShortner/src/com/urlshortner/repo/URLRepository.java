package com.urlshortner.repo;

public interface URLRepository {

    void saveUrl(String shortUrl, String originalUrl);

    String getLongUrl(String shortUrl);
}
