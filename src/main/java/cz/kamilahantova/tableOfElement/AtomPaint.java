package cz.kamilahantova.tableOfElement;

import java.awt.Color;
import java.awt.Graphics2D;

//public class cz.kamilahantova.tableOfElement.AtomPaint extends JPanel {
public class AtomPaint {

    private int layer; // pocet vrstev
    private int[] elektron; // mn. elektronu v jednotlivych vrstvach

    public AtomPaint(int layer, int[] elektron) {

        this.layer = layer;
        this.elektron = elektron;
        // setMinimumSize(new Dimension(100, 100));
        // setBackground(Color.CYAN);
    }

    public void draw(Graphics2D g2, int width) {

        int jadro = width / 20;
        width = 3 * width / 4;
        g2.setColor(Color.black);
        g2.fillOval(width - jadro, width - jadro, jadro * 2, jadro * 2);
        for (int i = 0; i < layer; i++) {
            int first = (i + 1) * width / layer;
            g2.drawOval(width - first, width - first, first * 2, first * 2);

            int n = elektron[i];

            for (int j = 0; j < n; j++) {
                double t = 2 * Math.PI * j / n;
                int x = (int) Math.round(width + first * Math.cos(t + 2));
                int y = (int) Math.round(width + first * Math.sin(t + 2));
                g2.fillOval(x - jadro, y - jadro, jadro * 2, jadro * 2);
            }

        }

    }

}