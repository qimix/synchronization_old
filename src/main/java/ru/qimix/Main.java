package ru.qimix;

import java.util.*;

public class Main {
    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();


    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 1000; i++) {
            System.out.println(generateRoute("RLRFR", 100));
        }
    }

    public static String generateRoute (String letters,int length) throws InterruptedException {
        Random random = new Random();
        StringBuilder route = new StringBuilder();
        Runnable task = () -> {
            for (int i = 0; i < length; i++) {
                route.append(letters.charAt(random.nextInt(letters.length())));
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.join();
        return route.toString();
    }

}