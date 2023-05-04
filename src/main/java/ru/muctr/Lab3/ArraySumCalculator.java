package ru.muctr.Lab3;

import java.util.Arrays;
import java.util.Random;

public class ArraySumCalculator {
    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public int[] getLengths(String[] strings) {
        int[] lengths = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            lengths[i] = strings[i].length();
        }
        return lengths;
    }

    public static void main(String[] args) {
        Random random = new Random();

        int[] array = new int[1000];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        int sum = sum(array);
        System.out.println("Сумма всех элементов массива: " + sum);

        String[] strings = {"apple", "banana", "orange"};
        int[] lengths = new ArraySumCalculator().getLengths(strings);
        System.out.println("Длины строк: " + Arrays.toString(lengths));
    }
}

