package com.codecool;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {

    private String filePath;
    int fromLine;
    int toLine;

    public void setup(String filePath, int fromLine, int toLine) {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

        if (toLine < fromLine)
            throw new IllegalArgumentException("toLine can't be lowe than fromLine!");

        if (fromLine < 1)
            throw new IllegalArgumentException("fromLine can't be lowe than 1!");
    }

    public String read() throws IOException {

        return Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
    }

    public String readLines() throws IOException {
        String newline = System.getProperty("line.separator");
        String[] textLines = read().split(newline);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = fromLine - 1; i < toLine; i++) {
            stringBuilder.append(textLines[i]).append(newline);
        }

        return stringBuilder.toString();
    }
}
