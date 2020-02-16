package com.codecool;

import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilePartReaderTest {
    private FilePartReader filePartReader = new FilePartReader();

    @Test
    public void testSetupMethodParameters() {
        Integer fromLine = 1;
        Integer toLine = 5;
        String filePath = "target/classes/txtFiles/module_oop.md";
        filePartReader.setup(filePath, fromLine, toLine);

        assertEquals(String.class, filePath.getClass());
        assertEquals(Integer.class, fromLine.getClass());
        assertEquals(Integer.class, toLine.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetupForThrownExceptionWhenToLineIsSmallerThanFromLine() {
        filePartReader.setup("target/classes/txtFiles/module_oop.md", 3, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetupForThrownExceptionWhenFromLineIsLowerThanZero() {
        filePartReader.setup("target/classes/txtFiles/module_oop.md", 0, 13);
    }

    @Test
    public void testIfReadMethodReturnsString() throws IOException {
        filePartReader.setup("target/classes/txtFiles/module_oop.md", 1, 1);
        assertEquals(String.class, filePartReader.read().getClass());
    }

    @Test(expected = IOException.class)
    public void testIfFilePathIsValid() throws IOException {
        filePartReader.setup("invalidPath.txt", 1, 1);
        filePartReader.read();
    }

    @Test()
    public void testIfReadLinesMethodUsesReadMethod() {

    }
}
