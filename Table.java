
import java.awt.BorderLayout;
import java.io.*;
import java.net.URISyntaxException;

import javax.swing.JPanel;

public class Table extends JPanel {

    public Table() {
        setLayout(new BorderLayout());
        try {
            BufferedReader bf = new BufferedReader(
                    new FileReader(new File(Table.class.getResource("/resources").toURI())));
            try {
                String line = bf.readLine();
                String[] array = line.split(" ");
                int numb = Integer.parseInt(array[2]);
                int[] elektron = new int[numb];
                for (int i = 0; i < numb; i++) {
                    elektron[i] = Integer.parseInt(array[3 + i]);
                }

                this.add(new Element(array[0], array[1], numb, elektron));
                // this.add(new Element(array[0], array[1], numb, elektron));
            } finally {
                bf.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
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