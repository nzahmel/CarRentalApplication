package system;

import javax.swing.*;
import java.awt.*;

public class TestOhneCardLayout {
    JFrame frame = new JFrame("Testfenster ohne CardLayout");
    JPanel mainPanel = new JPanel();
    JPanel secondPanel = new JPanel();
    JButton firstBtn = new JButton("Gehe zum 2. Fenster");
    JButton secondBtn = new JButton("Gehe zum 1. Fenster");

    TestOhneCardLayout(){
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel.setBackground(Color.GREEN);
        secondPanel.setBackground(Color.BLUE);

        mainPanel.add(firstBtn);
        secondPanel.add(secondBtn);

        frame.add(mainPanel);

        firstBtn.addActionListener(e -> {
            frame.remove(mainPanel);
            frame.add(secondPanel);
            frame.revalidate();
            frame.repaint();
        });

        secondBtn.addActionListener(e -> {
            frame.remove(secondPanel);
            frame.add(mainPanel);
            frame.revalidate();
            frame.repaint();
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TestOhneCardLayout();
    }
}
