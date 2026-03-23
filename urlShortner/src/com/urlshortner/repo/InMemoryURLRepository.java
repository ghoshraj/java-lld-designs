package com.urlshortner.repo;

import java.util.HashMap;
import java.util.Map;

public class InMemoryURLRepository implements URLRepository{

    private Map<String, String> urlMap = new HashMap<>();

    @Override
    public void saveUrl(String shortUrl, String originalUrl) {
        urlMap.put(shortUrl, originalUrl);
    }

    @Override
    public String getLongUrl(String shortUrl) {
        return urlMap.get(shortUrl);
    }
}
