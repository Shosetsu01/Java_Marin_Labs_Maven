package ru.muctr.Lab3;
import java.util.ArrayList;
import java.util.Scanner;

public class SplitFromLabOne {
/*
    Задание 2.
    Напишите алгоритм разбиения строки на слова, не используя метод split().
*/
    public static ArrayList<String> splitString(String textString) {
        char[] charArray = textString.toCharArray();
        ArrayList<String> wordList = new ArrayList<>();
        String word = "";

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ') {
                word = word + charArray[i];
                if (i == charArray.length - 1) {
                    wordList.add(word);
                }
            } else {
                char[] charTempArray = word.toCharArray();
                if (charTempArray.length != 0 && charTempArray[0] != ' ') {
                    wordList.add(word);
                    word = "";
                }
            }
        }

        return wordList;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите текст: ");
        String textString = in.nextLine();

        ArrayList<String> result = splitString(textString);
        System.out.println("\nПолучившийся список слов: ");
        System.out.println(result);
    }
}
