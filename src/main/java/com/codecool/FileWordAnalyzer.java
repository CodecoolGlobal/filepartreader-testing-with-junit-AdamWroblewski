package com.codecool;

import java.io.IOException;
import java.util.*;

public class FileWordAnalyzer {

    FilePartReader filePartReader;
    List<String> wordsList;


    public FileWordAnalyzer(FilePartReader filePartReader) throws IOException {
        this.filePartReader = filePartReader;
        this.wordsList = new ArrayList<>(Arrays.asList(filePartReader.readLines().split("\\s")));
    }

    public List<String> getWordsOrderedAlphabetically() {

        wordsList.sort(Comparator.comparing(String::toLowerCase));
        return wordsList;
    }

    public List<String> getWordsContainingSubstring (String subString ){



        return new ArrayList<String>();
    }


//    public List getStringsWhichPalindromes (){}
}
