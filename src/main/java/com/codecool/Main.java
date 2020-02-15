package com.codecool;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("target/classes/txtFiles/README.txt", 1, 1);
        try {
            System.out.println(filePartReader.readLines());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
