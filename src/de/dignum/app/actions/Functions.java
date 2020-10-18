package de.dignum.app.actions;

import de.dignum.app.QuickSort;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Functions {

    public static ArrayList<Integer> counter_array = new ArrayList<>();

    public static void getURLToFolder() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter url: ");
        String url = scanner.nextLine();

        getFiles(new File(url));
    }

    public static void getFiles(File folder) {
        File[] files = folder.listFiles();
        assert files != null;

        for(File file : files) {
            checkIfFileIsPDF(file);
        }

        int[] all_file_nummbers = new int[counter_array.size()];
        for(int i = 0; i < all_file_nummbers.length; i++) {
            all_file_nummbers[i] = counter_array.get(i).intValue();
        }

        QuickSort.quickSort(all_file_nummbers);
        System.out.println(all_file_nummbers);
        for(int i = 0; i < all_file_nummbers.length; i++) {
            System.out.println(all_file_nummbers[i]);
        }

    }

    public static boolean checkIfFileIsPDF(File file) {
        int lastIndexOf = file.getName().lastIndexOf(".");
        if(file.getName().substring(lastIndexOf).equalsIgnoreCase(".pdf")) {
            System.out.println(file.getName());
            getFirstCounter(file);
            return true;
        }
        return false;
    }

    public static void getFirstCounter(File file) {
        String[] file_split = file.getName().split("_");
        counter_array.add(Integer.valueOf(file_split[0]));
    }

}
