package com.codecool;

import com.google.common.collect.Ordering;
import org.junit.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileWordAnalyzerTest {
    FilePartReader filePartReader = new FilePartReader();


    @Test
    public void testIfGetWordsOrderedAlphabeticallySortProperly() throws IOException {
        filePartReader.setup("target/classes/txtFiles/module_oop.md", 1, 5);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        List<String> actual = fileWordAnalyzer.getWordsOrderedAlphabetically();

        List<String> expected = fileWordAnalyzer.getWordsOrderedAlphabetically();
        expected.sort(Comparator.comparing(String::toLowerCase));

        assertEquals(expected, actual);
    }

    @Test
    public void testIfGetWordsContainingSubstringFilterProperly() throws IOException {
        filePartReader.setup("target/classes/txtFiles/module_oop.md", 1, 15);
        String subString = "ti";
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        List<String> actual = fileWordAnalyzer.getWordsContainingSubstring(subString);
        List<String> expected = actual.stream()
                .filter(word -> word.contains(subString))
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }
}
