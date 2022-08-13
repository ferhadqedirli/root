package com.example.pms.util;

import java.util.Random;

public class NumberFunctions {

    private final static Random random = new Random();

    public static String generateUniqueNumber(int len) {
        String AB = "0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static int getRandomNumber() {

        int min = 100000;
        int max = 999999;

        return random.nextInt((max - min) + 1) + min;
    }

}
