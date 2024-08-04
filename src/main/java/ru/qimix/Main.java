package ru.qimix;

import java.util.*;

public class Main {
    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();
    static int treadCount = 0;

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 1000; i++) {
            new Robot("RLRFR", 100, treadCount).start();
            treadCount++;
        }
    }

    static class Robot extends Thread {
        String letters;
        Integer length;
        Integer treadCount;

        public Robot(String letters, int length, int treadCount){
            this.letters = letters;
            this.length = length;
            this.treadCount = treadCount;
        }

        public void run(){
            generateRoute(letters, length);
        }

        public String generateRoute(String letters, int length) {
            System.out.println("----- Hello from tread " + treadCount + " ------" );
            Random random = new Random();
            StringBuilder route = new StringBuilder();
            for (int i = 0; i < length; i++) {
                route.append(letters.charAt(random.nextInt(letters.length())));
            }
            System.out.println(route.toString());
            System.out.println("Thread " + treadCount +" finish");
            return route.toString();
        }

    }
}