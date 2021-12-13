package com.reactcwqr.codewars.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;

public class CalendarWeek  extends DefaultService {
    private String date;
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String solve() {
        return getCalendarWeek(date); }


        private static String getCalendarWeek(String dateString) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(dateString, formatter);
            int week = localDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
            return week+"";
        }
    }
