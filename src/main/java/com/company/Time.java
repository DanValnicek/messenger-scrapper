package main.java.com.company;

import java.time.LocalDateTime;


import java.time.format.DateTimeFormatter;

public class Time {

    private static volatile String timeSend;
    public static void time() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeNow = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println("nothing happens at: " + timeNow);
    }
    public static String minutes() {
        DateTimeFormatter minutes = DateTimeFormatter.ofPattern("HH:mm");
        String timeSend = minutes.format(LocalDateTime.now());
        return timeSend;

    }
}

