package com.codecool;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("target/classes/txtFiles/lorem-ipsum.txt", 1, 37);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        try {
            System.out.println("words: " + fileWordAnalyzer.getWordsOrderedAlphabetically());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
