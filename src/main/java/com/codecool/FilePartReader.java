package com.codecool;

import java.io.*;
import java.util.Scanner;

public class FilePartReader {

    private String filePath;

    public void setup(String filePath, int fromLine, int toLine) {
        this.filePath = filePath;

        if (toLine < fromLine)
            throw new IllegalArgumentException("toLine can't be lowe than fromLine!");

        if (fromLine < 1)
            throw new IllegalArgumentException("fromLine can't be lowe than 1!");
    }

    public String read() throws IOException {
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);

        Scanner input = new Scanner(file);
        while (input.hasNextLine())
            System.out.println(input.nextLine());

        return "";
    }
}
