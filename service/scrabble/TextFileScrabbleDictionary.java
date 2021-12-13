package com.reactcwqr.codewars.service.scrabble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TextFileScrabbleDictionary implements ScrabbleDictionary {
    private List<Word> words;

    public TextFileScrabbleDictionary(String filePath) throws Exception {
        words = new ArrayList<>();
        loadWords(filePath);
    }

    @Override
    public Word getWordAt(int index) {
        return words.get(index);
    }

    @Override
    public int wordCount() {
        return words.size();
    }

    private void loadWords(String filePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
        String word;

        while ((word = reader.readLine()) != null) {
            words.add(new Word(word));
        }
    }

}
