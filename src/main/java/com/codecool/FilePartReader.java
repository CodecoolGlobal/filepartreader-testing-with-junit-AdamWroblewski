package com.codecool;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

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

        return Files.readString(Paths.get(filePath), StandardCharsets.US_ASCII);
    }

    public String readLines() throws IOException {
        return read();
    }
}
