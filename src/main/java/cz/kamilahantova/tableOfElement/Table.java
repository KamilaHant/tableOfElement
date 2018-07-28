package cz.kamilahantova.tableOfElement;

import java.awt.BorderLayout;
import java.io.*;
import java.net.URISyntaxException;

import javax.swing.JPanel;

public class Table extends JPanel {

    public Table() {
        setLayout(new BorderLayout());
        try {
            try (BufferedReader bf = new BufferedReader(
                    new InputStreamReader(Table.class.getResourceAsStream("/elements.txt")))) {
                String line = bf.readLine();
                String[] array = line.split(" ");
                int numb = Integer.parseInt(array[2]);
                int[] elektron = new int[numb];
                for (int i = 0; i < numb; i++) {
                    elektron[i] = Integer.parseInt(array[3 + i]);
                }

                this.add(new Element(array[0], array[1], numb, elektron));
                // this.add(new cz.kamilahantova.tableOfElement.Element(array[0], array[1], numb, elektron));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        /*
         * this.add(new JButton()); this.add(new JButton("2")); this.add(new
         * JButton("3")); this.add(new JButton("1")); this.add(new
         * JButton("2")); this.add(new JButton("3")); this.add(new
         * JButton("1")); this.add(new JButton("2")); this.add(new
         * JButton("3")); this.add(new JButton("1")); this.add(new
         * JButton("2")); this.add(new JButton("3")); this.add(new
         * JButton("1")); this.add(new JButton("2")); this.add(new
         * JButton("3"));
         */
    }

}