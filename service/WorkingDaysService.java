package com.reactcwqr.codewars.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.jni.Local;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class WorkingDaysService extends DefaultService {

//    private LocalDate start;
//    private LocalDate end;
    private String start;
    private String end;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String solve() { return count(start, end); }

    //private long count(final LocalDate start, final LocalDate end) {
    private String count(final String startDate, final String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        LocalDate newStart = findMonday(start);
        LocalDate newEnd = findFriday(end);
        long diffI = 0;
        diffI = ChronoUnit.DAYS.between(newStart, newEnd);
        long weekends = (diffI / 7) * 2;
        long result = diffI + 1 - weekends;
        return result + "";
    }

    // first Monday of Month
    private LocalDate findMonday(LocalDate date) {
        LocalDate dateOfFirstMonday = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        // System.out.println("First Monday: " + dateOfFirstMonday);
        return dateOfFirstMonday;
    }

    // Last  Friday of month
    private LocalDate findFriday(LocalDate date) {
        LocalDate dateOfLastFriday = date.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
        // System.out.println("LastFriday: " + dateOfLastFriday);
        return dateOfLastFriday;
    }

}
