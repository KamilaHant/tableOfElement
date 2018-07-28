package cz.kamilahantova.tableOfElement;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFR extends JFrame {

    public MainFR() {
        Dimension framesize = new Dimension(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(framesize);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);
        setTitle("table");
        buildGUI();

    }

    private void buildGUI() {
        // TODO Auto-generated method stub
        this.add(new Table(), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MainFR fr = new MainFR();

    }

}