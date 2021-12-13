package com.reactcwqr.codewars.service;

public class WhatTimeIsItService extends DefaultService {
private String time;

    @Override
    public String solve() {
        return toHumanTime(time);
    }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

        private static String toHumanTime(String time) {
            String stringH = time.replaceAll(":.+$", "");
            String stringM = time.replaceAll("^(\\d.)", "");
            String stringM1 = stringM.replaceAll("\\D", "");
            return printWords(Integer.valueOf(stringH), Integer.valueOf(stringM1));
        }

        private static String printWords(int h, int m) {
            String nums[] = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                    "eleven", "twelve", "thirteen", "fourteen", "fifteen" ,"sixteen", "seventeen", "eighteen", "nineteen", "twenty",
                    "twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five", "twenty-six",
                    "twenty-seven", "twenty-eight", "twenty-nine"};

            if (m == 0) return nums[h%12] + " o'clock";
            else if (m == 1) return "one minute past " + nums[h%12];
            else if (m == 59) return "one minute to " + nums[(h % 12) + 1];
            else if (m == 15) return "quarter past " + nums[h%12];
            else if (m == 30) return "half past " + nums[h%12];
            else if (m == 45) return "quarter to " + nums[(h % 12) + 1];
            else if (m <= 30) return nums[m] + " minutes past " + nums[h%12];
            //  else if (m > 30)
            return nums[60 - m] + " minutes to " + nums[(h % 12) + 1];
        }
    }
