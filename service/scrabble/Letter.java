package com.reactcwqr.codewars.service.scrabble;

import java.util.HashMap;
import java.util.Map;

public class Letter {
    private final static Map<Character, Integer> POINTS = new HashMap<>() {{
        put('a', 1);
        put('e', 1);
        put('i', 1);
        put('n', 1);
        put('o', 1);
        put('r', 1);
        put('s', 1);
        put('w', 1);
        put('z', 1);
        put('c', 2);
        put('d', 2);
        put('k', 2);
        put('l', 2);
        put('m', 2);
        put('p', 2);
        put('t', 2);
        put('y', 2);
        put('b', 3);
        put('g', 3);
        put('h', 3);
        put('j', 3);
        put('ł', 3);
        put('u', 3);
        put('x', 5);
        put('ą', 5);
        put('ć', 5);
        put('ę', 5);
        put('f', 5);
        put('ń', 5);
        put('ó', 5);
        put('ś', 5);
        put('ż', 5);
        put('ź', 5);
    }};

    private char value;
    private int points;

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Letter(char value) {
        this.value = value;
        this.points = calculatePoints(value);
    }


    private int calculatePoints(char c) {
        return POINTS.getOrDefault(c, 0);
    }
}
