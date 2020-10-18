package de.dignum.app.actions;

import org.apache.commons.lang3.Range;

import java.io.File;
import java.util.*;

public class actions {

    static List<Integer> original_numbers = new ArrayList<>();
    static List<Integer> numbers = new ArrayList<>();

    public static int count = 0;
    public static int position = 0;
    public static boolean flag = false;

    public static void read_directory(File folder) {
        File[] files = folder.listFiles();
        for(File file : files) {
            addNumber(file);
            getNumbers(file);
        }

        int[] a = original_numbers.stream().mapToInt(i->i).toArray();

        int arr[] = { 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 18, 20, 21, 23 };
        findMissingNumbers(a, a[0], a[original_numbers.size() - 1]);
    }

    private static void addNumber(File file) {
        String[] name = file.getName().split("_");

        original_numbers.add(Integer.parseInt(name[0]));
    }

    static void findMissingNumbers(int[] a, int first, int last) {
        for (int i = first; i < a[0]; i++) {
            System.out.println(i);
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1+a[i-1]; j < a[i]; j++) {
                System.out.println(j);
            }
        }

        for (int i = 1+a[a.length-1]; i <= last; i++) {
            System.out.println(i);
        }
    }

    private static void getNumbers(File file) {
        String[] name = file.getName().split("_");
        int file_count = original_numbers.size();
        numbers.add((original_numbers.get(original_numbers.size() - 1) - original_numbers.get(0)));
    }
}
