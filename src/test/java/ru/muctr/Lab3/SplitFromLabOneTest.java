package ru.muctr.Lab3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SplitFromLabOneTest {
    @Test
    public void testSplitString_emptyInput() {
        String input = "";
        ArrayList<String> expectedOutput = new ArrayList<>();

        ArrayList<String> actualOutput = SplitFromLabOne.splitString(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSplitString_singleWord() {
        String input = "Hello";
        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("Hello");

        ArrayList<String> actualOutput = SplitFromLabOne.splitString(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSplitString_multipleWords() {
        String input = "Этот тестовый метод был применен к коду из лабы номер один.";
        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("Этот");
        expectedOutput.add("тестовый");
        expectedOutput.add("метод");
        expectedOutput.add("был");
        expectedOutput.add("применен");
        expectedOutput.add("к");
        expectedOutput.add("коду");
        expectedOutput.add("из");
        expectedOutput.add("лабы");
        expectedOutput.add("номер");
        expectedOutput.add("один.");

        ArrayList<String> actualOutput = SplitFromLabOne.splitString(input);

        assertEquals(expectedOutput, actualOutput);
    }
}
