package com.reactcwqr.codewars.service;
import java.util.regex.Pattern;

public class Regex24HoursService extends DefaultService {
    private String time;

    @Override
    public String solve() {
        return validateTime(time);
    }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    private static String validateTime(String time) {
        String pattern = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])";
        boolean t = Pattern.matches(pattern, time);
        String result = "" + t;
        return result;
    }
}
