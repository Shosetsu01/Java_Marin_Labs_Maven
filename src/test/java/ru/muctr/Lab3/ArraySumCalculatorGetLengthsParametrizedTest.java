package ru.muctr.Lab3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;

public class ArraySumCalculatorGetLengthsParametrizedTest {
    private ArraySumCalculator calculator = new ArraySumCalculator();

    @ParameterizedTest
    @CsvSource({"apple,5", "banana,6", "orange,6", "kiwi,4", "grape,5"})
    public void testGetLengths(String string, int expectedLength) {
        int[] actualLengths = calculator.getLengths(new String[]{string});
        Assertions.assertEquals(expectedLength, actualLengths[0]);
    }
}
