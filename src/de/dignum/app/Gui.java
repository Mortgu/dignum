package de.dignum.app;

import de.dignum.app.actions.actions;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Gui extends JPanel {

    public Gui() {
        String [] header={"nr."};

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        String[][] data = new String[actions.missing_numbers.size()][actions.missing_numbers.size()];
        for(int i = 0; i < actions.missing_numbers.size(); i++) {
            data[i][i] = actions.missing_numbers.get(i).toString();
        }

        DefaultTableModel model = new DefaultTableModel(data, header);

        JTable table = new JTable(model);

        //table.setPreferredScrollableViewportSize(new Dimension(480,200));
        table.setFillsViewportHeight(true);
        table.setBounds(0, 250, 480, 200);
        table.setLayout(null);

        JScrollPane js=new JScrollPane(table);
        js.setVisible(true);
        add(js);
    }


}
