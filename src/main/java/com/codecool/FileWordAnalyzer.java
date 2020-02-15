package com.codecool;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileWordAnalyzer {

    FilePartReader filePartReader;
    List<String> wordsList;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {

        wordsList = new ArrayList<>(Arrays.asList(filePartReader.readLines().split("\\s")));
        wordsList.sort(Comparator.comparing(String::toLowerCase));
        return wordsList;
    }

    public List<String> getWordsContainingSubstring (String subString ) throws IOException {

        wordsList = new ArrayList<>(Arrays.asList(filePartReader.readLines().split("\\s")));

        return wordsList.stream()
                .filter(word -> word.contains(subString))
                .collect(Collectors.toList());
    }


//    public List getStringsWhichPalindromes (){}
}
