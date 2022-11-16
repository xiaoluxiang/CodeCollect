package com.lushixiang.localDateTime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EntryExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        LocalDateTime parse = LocalDateTime.parse("2022-10-19 11:11:11", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("")
        System.out.println(parse);
//        ChronoUnit.DAYS;


    }
}
