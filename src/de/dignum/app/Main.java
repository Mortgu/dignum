package de.dignum.app;

import de.dignum.app.actions.actions;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        actions.read_directory(new File("C:\\Users\\oskar\\Desktop\\test"));
    }
}
