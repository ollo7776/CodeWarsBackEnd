package com.reactcwqr.codewars.service.scrabble;

import java.util.ArrayList;

public class Word extends ArrayList<Letter> {
    public Word() {

    }

    public Word(String text) {
        for (char c : text.toCharArray()) {
            add(new Letter(c));
        }
    }

    public int getPoints() {
        int total = 0;
        for (Letter letter : this) {
            total += letter.getPoints();
        }
        if (size() >= 7) {
            total *= 10;
        }
        return total;
    }
    @Override
    public String toString() {
        String text = "";
        for (Letter letter : this) {
            text += letter.getValue();
        }
        return text + " (" + getPoints() + ")" ;
    }

}
