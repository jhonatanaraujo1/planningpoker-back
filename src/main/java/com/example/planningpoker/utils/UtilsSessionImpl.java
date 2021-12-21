package com.example.planningpoker.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UtilsSessionImpl implements UtilsSession{
    @Override
    public String generateHash(String title) {
        String val = title + System.currentTimeMillis();
        return Base64.getUrlEncoder().encode(val.getBytes(StandardCharsets.UTF_8)).toString();
    }
}
