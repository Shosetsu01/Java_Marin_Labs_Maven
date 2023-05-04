package ru.muctr.Lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArraySumCalculatorTest {
    private ArraySumCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new ArraySumCalculator();
    }

    @Test
    public void testSum() {
        int[] array = {1, 2, 3, 4, 5};
        int expectedSum = 15;

//        long startTime = System.currentTimeMillis();
//        long endTime = System.currentTimeMillis();

        Assertions.assertEquals(expectedSum, calculator.sum(array));
//        Assertions.assertTrue(endTime - startTime < 10, "Время выполнения больше 10 мс");
    }

    @Test
    public void testGetLengths() {
        String[] strings = {"apple", "banana", "orange"};
        int[] expectedLengths = {5, 6, 6};
//        int[] actualLengths = calculator.getLengths(strings);
        Assertions.assertArrayEquals(expectedLengths, calculator.getLengths(strings));
    }
}
