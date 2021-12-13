package com.reactcwqr.codewars.service.scrabble;
import com.reactcwqr.codewars.service.DefaultService;
import java.util.List;

public class ScrabbleHelper extends DefaultService {
    private String letters;
    private ScrabbleDictionary dictionary;
    public ScrabbleHelper() throws Exception {
        dictionary = new TextFileScrabbleDictionary("slowa.txt");
    }
    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    @Override
    public String solve() throws Exception {
        ScrabbleSolver solver = new ScrabbleSolver(dictionary);

        List < Word > words = solver.solve(letters);
        return words.toString();
    }
}
