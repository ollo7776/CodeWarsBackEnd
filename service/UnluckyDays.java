package com.reactcwqr.codewars.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UnluckyDays extends DefaultService {
    private String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String solve() {
        return unluckyDays(year);
    }

    private static String unluckyDays(String year) {
        String dateS = "01-13-" + year;
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            Date date = dateFormat.parse(dateS);
            cal.setTime(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        int counter = 0;
        int months = 0;
        while (months++ < 12) {
            if (Calendar.FRIDAY == cal.get(Calendar.DAY_OF_WEEK)) {
                counter++;
            }
            cal.add(Calendar.MONTH, 1);
        }
        return counter + "";
    }
}






