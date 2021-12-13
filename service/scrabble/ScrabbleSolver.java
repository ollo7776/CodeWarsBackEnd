package com.reactcwqr.codewars.service.scrabble;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScrabbleSolver {
    private ScrabbleDictionary dictionary;

    public ScrabbleSolver(ScrabbleDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public List<Word> solve(List<Letter> letters) {
        List<Word> result = new ArrayList<>();
        for (int i = 0; i < dictionary.wordCount(); i++) {
            Word word = dictionary.getWordAt(i);
            if (canAssemble(letters, word)) {
                result.add(word);
            }
        }
//      result.sort(((o1, o2) -> o1.getPoints() - o2.getPoints()));
        result.sort((o1, o2) -> SortByPointsThenByText(o1, o2));
        return result;
    }

    private int SortByPointsThenByText(Word o1, Word o2) {
        int delta = -(o1.getPoints() - o2.getPoints());
        if (delta == 0) {
            return o1.toString().compareTo(o2.toString());
        }
        return delta;
    }


    public List<Word> solve(Word word) {
        return solve((List<Letter>) word);
    }

    public List<Word> solve(String text) {
        return solve(new Word(text));
    }

    private boolean canAssemble(List<Letter> letters, Word word) {
        List<Character> source = letters.stream().map(l -> l.getValue()).collect(Collectors.toList());
        List<Character> destination = word.stream().map(l -> l.getValue()).collect(Collectors.toList());

        for (int i = destination.size() - 1; i >= 0; i--) {
            Character c = destination.get(i);
            if (source.contains(c)) {
                destination.remove(i);
                source.remove(c);
            } else {
                return false;
            }
        }
        return destination.size() == 0;
    }
}
