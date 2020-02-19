package com.codecool;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileWordAnalyzerTest {
    FilePartReader filePartReader = new FilePartReader();


    @Test
    public void testIfGetWordsOrderedAlphabeticallySortProperly() throws IOException {
        filePartReader.setup("target/classes/txtFiles/test.txt", 1, 2);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        List<String> actual = fileWordAnalyzer.getWordsOrderedAlphabetically();
        System.out.println(actual);

        List<String> expected = new ArrayList<>(Arrays.asList("adipiscing", "amet",
                "consectetur", "convallis", "dolor", "elit", "elit", "erat", "eros",
                "eu", "euismod", "felis", "id", "ipsum", "libero", "Lorem", "mattis",
                "Nam", "pulvinar", "quis", "sit", "suscipit", "tristique", "Vivamus"));

        assertEquals(expected, actual);
    }

    @Test
    public void testIfGetWordsContainingSubstringFilterProperly() throws IOException {
        filePartReader.setup("target/classes/txtFiles/test.txt", 1, 2);
        String subString = "er";
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        List<String> actual = fileWordAnalyzer.getWordsContainingSubstring(subString);
        List<String> expected = Arrays.asList("libero", "eros", "erat");

        assertEquals(expected, actual);
    }
}
