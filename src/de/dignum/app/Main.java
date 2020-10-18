package de.dignum.app;

import de.dignum.app.actions.actions;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Functions.getURLToFolder();
        actions.read_directory(new File("C:\\Users\\oskar\\Desktop\\test"));
    }
}
