package com.example.urlshortener.utils;

import java.util.Random;

public class RandomIdGenerator {
    private static final Random random = new Random();
    private static final char[] CHAR_ARRAY = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final int DEFAULT_LENGTH = 6;

    private RandomIdGenerator() {
    }

    public static String getUniqueId() {
        var uniqueId = new StringBuilder();

        for (int i = 0; i < DEFAULT_LENGTH; i++) {

            int randomIndex = random.nextInt(CHAR_ARRAY.length);
            uniqueId.append(CHAR_ARRAY[randomIndex]);
        }

        return uniqueId.toString();
    }
}
