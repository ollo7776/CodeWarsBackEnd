package com.reactcwqr.codewars.service;

import java.util.ArrayList;

public class DiktatCheck extends DefaultService {
    private String text1;
    private String text2;

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    @Override
    public String solve() {
        return isTheSame(text1, text2);
    }

    private String isTheSame(String text1, String text2) {
        String[] arrayOfWords1 = text1.split(" ");
        String[] arrayOfWords2 = text2.split(" ");
        //ArrayList <String> errors = new ArrayList<>();
        String errors = "";
        if (arrayOfWords1.length != arrayOfWords2.length) {
            return "!= Les textes ont des nombres de mots différents";
        }
        for (int i = 0; i < arrayOfWords1.length; i++) {
            if (!arrayOfWords1[i].equals(arrayOfWords2[i])) {
                //System.out.println("Corriger: "+arrayOfWords1[i] + " Éclat: " + arrayOfWords2[i]);
//                String error = "Corriger: " + arrayOfWords1[i] + " Éclat: " + arrayOfWords2[i];
//                errors.add(error);
                errors += "corrige: " + arrayOfWords1[i] + " --- " + arrayOfWords2[i] + "newLine";
            }
        }
        if (errors.length() != 0) {
            return errors;
        } else
            return "Correctement!";
    }
}
