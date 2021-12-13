package com.reactcwqr.codewars.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Meetings extends DefaultService {
    private String list;

    @Override
    public String solve() {
        return meetings(list);
    }
    public String getList() { return list; }
    public void setList(String list) { this.list = list; }

    private static String meetings(String list) {
        String firstName = "";
        String lastName, name;
        List<String> guestList = Arrays.asList(list.split(";"));
        List<String> mapList = new ArrayList<>();
        for (int i = 0; i < guestList.size(); i++) {
            name = guestList.get(i);
            int index = name.indexOf(":");
            firstName = name.substring(0, index).toUpperCase();
            lastName = name.substring(index + 1).toUpperCase();
            mapList.add("(" + lastName + ", " + firstName + ")");
        }
        String result = "";
        Collections.sort(mapList);
        for (String el : mapList) {
            result += el;
        }
        return result;


    }
}



