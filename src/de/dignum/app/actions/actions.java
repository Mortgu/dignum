package de.dignum.app.actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class actions {

    static List<Integer> numbers = new ArrayList<>();
    static List<Integer> missing_numbers = new ArrayList<>();
    static List<String> wrong_files = new ArrayList<>();

    public static void read_directory(File folder) {
        System.out.println("reading directory: " + folder);
        File[] files = folder.listFiles();
        assert files != null;
        for(File file : files) {
            addNumber(file);
        }

        // CHECK IF NUMBER IS CORRECT
        int[] a = numbers.stream().mapToInt(i->i).toArray();
        findMissingNumbers(a, a[0], a[numbers.size() - 1]);

        System.out.println("missing numbers: " + missing_numbers);

        // CHECK IF FILE CONTAINS XXX
        for(File file : files) {
            if(!isCorrect(file))
                wrong_files.add(file.getName());
        }

        System.out.print(wrong_files.size() + " wrong file(s) : " + wrong_files);
    }

    static void addNumber(File file) {
        String[] name = file.getName().split("_");

        if(getFileExtension(file))
            numbers.add(Integer.parseInt(name[0]));
    }

    static boolean getFileExtension(File file) {
        return file.getName().endsWith(".pdf");
    }

    static void findMissingNumbers(int[] a, int first, int last) {
        for (int i = first; i < a[0]; i++) {
            missing_numbers.add(i);
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1 + a[i - 1]; j < a[i]; j++) {
                missing_numbers.add(j);
            }
        }

        for (int i = 1 + a[a.length - 1]; i <= last; i++) {
            missing_numbers.add(i);
        }
    }

    static boolean isCorrect(File file) {
        return !file.getName().contains("xxx");
    }
}
