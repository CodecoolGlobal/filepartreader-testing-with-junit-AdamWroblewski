package com.codecool;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;
    private List<String> wordsList;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {

        wordsList = new ArrayList<>(Arrays.asList(filePartReader.readLines().split("\\s")));
        wordsList.sort(Comparator.comparing(String::toLowerCase));
        return wordsList;
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {

        wordsList = new ArrayList<>(Arrays.asList(filePartReader.readLines().split("\\s")));

        return wordsList.stream()
                .filter(word -> word.contains(subString))
                .collect(Collectors.toList());
    }


    public List<String> getStringsWhichPalindromes() throws IOException {

        wordsList = new ArrayList<>(Arrays.asList(filePartReader.readLines().split("\\s")));
        List<String> palindromes = new ArrayList<>();
        Stack<Character> stack1 = new Stack<>();
        StringBuilder reversedWord = new StringBuilder();

        for (String word : wordsList){
            reversedWord.setLength(0);
            for (char letter : word.toCharArray()){
                stack1.push(letter);
            }
            while (stack1.size() > 0){
                reversedWord.append(stack1.pop());
            }
            if (word.equals(reversedWord.toString())){
                palindromes.add(reversedWord.toString());
            }
        }
        return palindromes;
    }
}
