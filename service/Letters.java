package com.reactcwqr.codewars.service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Letters extends DefaultService {
    private String letters;

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    @Override
    public String solve() throws IOException {
        return letters7(letters);
    }

    private String letters7(String letters) throws IOException {
        String result = "";
        String fileName = "slowa.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        List<String> wordsList = new ArrayList<>();
        letters = letters.toLowerCase();

        while ((line = br.readLine()) != null) {
            if (line.length() < 8) {
                char[] letArray = letters.toCharArray();
                char[] lineArray = line.toCharArray();

                int counter = 0;
                for (int i = 0; i < letters.length(); i++) {
                    for (int j = 0; j < line.length(); j++) {
                        if (letArray[i] == lineArray[j]) {
                            counter++;
                            lineArray[j] = 'ä';
                            letArray[i] = 'ö';
                            if (counter == line.length()) {
                                //result += line + ",";
                                wordsList.add(line);
                                break;
                            }
                            if (counter == line.length()) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        wordsList.sort(Comparator.comparingInt(String::length));
        Collections.reverse(wordsList);
        return wordsList.toString();
     //   return letters + "!!!";
    }
}
