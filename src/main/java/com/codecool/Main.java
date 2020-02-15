package com.codecool;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("README.txt", 1, 1);
        try {
            filePartReader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
