package com.codecool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;
    private List<String> wordsList;
    private final String regex;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
        regex = "[^a-zA-Z\\s]+";
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {

        wordsList = new ArrayList<>(Arrays.asList(
                filePartReader.readLines().replaceAll(regex, "").split("\\s")));
        wordsList.sort(Comparator.comparing(String::toLowerCase));
        return wordsList;
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {

        wordsList = new ArrayList<>(Arrays.asList(
                filePartReader.readLines().replaceAll(regex, "").split("\\s")));

        return wordsList.stream()
                .filter(word -> word.contains(subString))
                .collect(Collectors.toList());
    }


    public List<String> getStringsWhichPalindromes() throws IOException {

        wordsList = new ArrayList<>(Arrays.asList(
                filePartReader.readLines().replaceAll(regex, "").split("\\s")));
        List<String> palindromes = new ArrayList<>();

        for (String word : wordsList) {
            for (int currentChar = 0; currentChar < word.length(); currentChar++) {
                int wordMiddle = (int) Math.ceil(word.length() / 2.0);

                if (word.toLowerCase().charAt(currentChar) != word.toLowerCase().charAt(word.length() - 1 - currentChar)) {
                    break;
                }
                if (currentChar == wordMiddle || wordMiddle == 1) {
                    palindromes.add(word);
                }
            }
        }
        return palindromes;
    }
}
