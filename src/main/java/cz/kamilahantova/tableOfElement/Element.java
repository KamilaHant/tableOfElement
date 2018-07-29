package cz.kamilahantova.tableOfElement;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.TextLayout;

import javax.swing.JPanel;

public class Element extends JPanel {

    private String name;
    private String atomNum;
    private AtomPaint img;

    public Element(String name, String atomNum, int layerNum, int[] elektron) {
        this.name = name;
        this.atomNum = atomNum;
        setLayout(new BorderLayout());
        img = new AtomPaint(layerNum, elektron);

        /*
         * try { img =
         * ImageIO.read(cz.kamilahantova.tableOfElement.Element.class.getResource("/resources/h.png")); } catch
         * (IOException e) { e.printStackTrace(); }
         */
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int width = getWidth();
        int height = getHeight();
        // System.out.println(width + " - " + height);

        Graphics2D g2 = (Graphics2D) g;

        int imgWidth = width / 3;
        int imgHeight = height / 3;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        // g2.drawImage(img.getScaledInstance(imgWidth, imgWidth,
        // Image.SCALE_SMOOTH), 10, 10, null);

        img.draw(g2, width / 4);

        TextLayout label = new TextLayout(name, new Font(Font.SANS_SERIF, Font.BOLD, imgWidth),
                g2.getFontRenderContext());

        int sirka = width / 2 - (int) label.getBounds().getWidth() / 2;
        int vyska = height / 2 + (int) label.getBounds().getHeight() / 2;

        label.draw(g2, sirka, vyska);

        TextLayout atomNumb = new TextLayout(atomNum, new Font(Font.SANS_SERIF, Font.BOLD, imgWidth / 2),
                g2.getFontRenderContext());

        sirka = width - (int) atomNumb.getBounds().getWidth() / 2 - (int) atomNumb.getBounds().getWidth(); // x
        vyska = 0 + (int) atomNumb.getBounds().getHeight() / 2 + (int) atomNumb.getBounds().getHeight(); // y

        atomNumb.draw(g2, sirka, vyska);

    }

}