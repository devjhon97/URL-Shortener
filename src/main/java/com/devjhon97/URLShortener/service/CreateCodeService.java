package com.devjhon97.URLShortener.service;

import java.util.Random;

public class CreateCodeService {
    private char[] alphanumericArray() {
        char[] alpha = new char[62];
        int index = 0;

        for (int i = 48; i <= 57; i++) {
            alpha[index] = (char) i;
            index++;
        }

        for (int i = 65; i <= 90; i++) {
            alpha[index] = (char) i;
            index++;
        }

        for (int i = 97; i <= 122; i++) {
            alpha[index] = (char) i;
            index++;
        }

        return alpha;
    }

    public String createCode() {
        Random random = new Random();
        StringBuilder str = new StringBuilder();

        char[] alphanumeric = alphanumericArray();
        int len = random.nextInt(6) + 5;

        while (str.length() < len) {
            char alphanum = alphanumeric[random.nextInt(62)];
            str.append(alphanum);
        }

        return str.toString();
    }
}
