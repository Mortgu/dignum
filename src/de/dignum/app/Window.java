package de.dignum.app;

import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        setTitle("dignum");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(new Gui());

        setVisible(true);
    }
}
