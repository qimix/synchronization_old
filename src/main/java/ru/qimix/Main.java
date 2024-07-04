package ru.qimix;

import java.util.*;

public class Main {
    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            generateRoute("RLRFR", 100);
        }

        for (Map.Entry<Integer, Integer> pair : sizeToFreq.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }

    public static String generateRoute(String letters, int length) throws InterruptedException {
        Random random = new Random();
        StringBuilder route = new StringBuilder();

        Runnable task = () -> {
            int count = 0;
            int freq = 0;

            for (int i = 0; i < length; i++) {
                char a = letters.charAt(random.nextInt(letters.length()));
                if (String.valueOf(a).toString().equals("R")) {
                    count++;
                    if (freq == 0) {
                        freq++;
                    }
                } else if(count != 0) {
                        synchronized (sizeToFreq) {
                            sizeToFreq.put(freq, count);
                        }
                        count = 0;
                        freq = 0;
                    }
                route.append(a);
                }
            };

        Thread thread = new Thread(task);
        thread.start();
        thread.join();
        return route.toString();
    }

}