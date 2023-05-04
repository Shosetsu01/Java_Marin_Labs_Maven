package ru.muctr.Lab5;

import lombok.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patent {
    private String title;
    private String number;
    private Date date;
    private List<String> inventors;
    private List<String> companies;
    private List<String> mpk;

    public static List<Patent> readPatentsFromFile(String fileName) {
        File file = new File(fileName);
        List<Patent> patents = new ArrayList<>();
        Set<String> patentNumbers = new HashSet<>(); // Set для удаления дубликатов

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\",\"");
                String patentNumber = fields[1];
                if (patentNumbers.contains(patentNumber)) {
                    continue; // пропустить дубликаты
                }
                patentNumbers.add(patentNumber);
                Patent patent = new Patent();
                patent.setTitle(fields[0]);
                patent.setNumber(patentNumber);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date = dateFormat.parse(fields[2]);
                    patent.setDate(date);
                } catch (ParseException e) {
                    System.err.println("Не удалось распознать дату патента: " + e.getMessage());
                }
                patent.setInventors(List.of(fields[3].split(";")));
                patent.setCompanies(List.of(fields[4].split(";")));
                patent.setMpk(List.of(fields[5].split(";")));
                patents.add(patent);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        return patents;
    }

    public static void main(String[] args) {
        List<Patent> patents = readPatentsFromFile("/Users/romaryin/IdeaProjects/Java_Marin_Labs_Maven/src/main/java/ru/muctr/Lab5/patents.csv");

        // Проверяем, есть ли в списке патенты по способам оптимизации
        boolean hasOptimizationPatents = false;
        int countOptimizationPatents = 0;
        for (Patent patent : patents) {
            if (patent.getTitle().toLowerCase().contains("optimization")) {
                hasOptimizationPatents = true;
                countOptimizationPatents++;
            }
        }
        System.out.println("Патенты по оптимизации: " + (hasOptimizationPatents ? "есть, " + countOptimizationPatents + " шт." : "нет"));

        // Считаем количество патентов для подкласса МІК G06F
        int countG06FPatents = 0;
        for (Patent patent : patents) {
            for (String mpk : patent.getMpk()) {
                if (mpk.startsWith("G06F")) {
                    countG06FPatents++;
                    break;
                }
            }
        }
        System.out.println("Количество патентов для подкласса МІК G06F: " + countG06FPatents);

        // Создаем коллекцию патентообладателей с указанием количества патентов для каждого
        Map<String, Integer> companyPatentCounts = new HashMap<>();
        for (Patent patent : patents) {
            for (String company : patent.getCompanies()) {
                int count = companyPatentCounts.getOrDefault(company, 0);
                companyPatentCounts.put(company, count + 1);
            }
        }
        System.out.println("Коллекция патентообладателей: " + companyPatentCounts);

        // Создаем сортированную по количеству изобретателей в порядке убывания коллекцию патентов не из Китая
        List<Patent> nonChinesePatents = new ArrayList<>();
        for (Patent patent : patents) {
            if (!patent.getNumber().startsWith("CN")) {
                nonChinesePatents.add(patent);
            }
        }
        nonChinesePatents.sort((p1, p2) -> Integer.compare(p2.getInventors().size(), p1.getInventors().size()));
        System.out.println("Сортированная по количеству изобретателей в порядке убывания коллекция патентов не из Китая: " + nonChinesePatents);

        // Записываем результаты работы программы в файл result.txt
        try (PrintWriter writer = new PrintWriter(new FileWriter("/Users/romaryin/IdeaProjects/Java_Marin_Labs_Maven/src/main/java/ru/muctr/Lab5/result.txt"))) {
            writer.println("Количество патентов по способам оптимизации: " + countOptimizationPatents);
            writer.println("Количество патентов с подклассом МІК G06F: " + countG06FPatents);
            writer.println("Количество патентов для каждого патентообладателя: " + companyPatentCounts);
            writer.println("Сортированная коллекция патентов не из Китая: " + nonChinesePatents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
