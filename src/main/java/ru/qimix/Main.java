package ru.qimix;

import java.util.*;

public class Main {
    public static final Map<Integer, Integer> sizeToFreq = Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            generateRoute("RLRFR", 100);
        }

        for (Map.Entry<Integer, Integer> pair : sizeToFreq.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }

    static int freq = 0;

    public static String generateRoute(String letters, int length) throws InterruptedException {
        Random random = new Random();
        StringBuilder route = new StringBuilder();

        Runnable task = () -> {
            int count = 0;
            int tmp = 0;

            for (int i = 0; i < length; i++) {
                char a = letters.charAt(random.nextInt(letters.length()));
                if (String.valueOf(a).toString().equals("R")) {
                    tmp++;
                } else {
                    if (count < tmp) {
                        count = tmp;
                    }
                    tmp = 0;
                }
                route.append(a);
            }
            freq++;
            sizeToFreq.put(freq, count);
        };

        Thread thread = new Thread(task);
        thread.start();
        thread.join();
        return route.toString();
    }
}