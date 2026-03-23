package com.urlshortner.hash;

import java.util.UUID;

public class RandomHashGenerator implements HashGenerator{

    @Override
    public String generateHashcode(String url) {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
