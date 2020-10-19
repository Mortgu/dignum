package de.dignum.app.actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class actions {

    static List<Integer> numbers = new ArrayList<>();

    public static void read_directory(File folder) {
        File[] files = folder.listFiles();
        assert files != null;
        for(File file : files) {
            addNumber(file);
        }

        int[] a = numbers.stream().mapToInt(i->i).toArray();

        findMissingNumbers(a, a[0], a[numbers.size() - 1]);
    }

    private static void addNumber(File file) {
        String[] name = file.getName().split("_");

        // TO:DO CHECK IF FILE IS .PDF
        if(getFileExtension(file))
            numbers.add(Integer.parseInt(name[0]));
    }

    private static boolean getFileExtension(File file) {
        return file.getName().endsWith(".pdf");
    }

    static void findMissingNumbers(int[] a, int first, int last) {
        for (int i = first; i < a[0]; i++) {
            System.out.print(i + ", ");
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1 + a[i - 1]; j < a[i]; j++) {
                System.out.print(j + ", ");
            }
        }

        for (int i = 1 + a[a.length - 1]; i <= last; i++) {
            System.out.print(i + ", ");
        }
    }
}
