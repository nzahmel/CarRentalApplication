package system;

import javax.swing.*;
import java.awt.*;


public class TestmitCardLayout{

    // Deklaration der Variablen
    JFrame frame;
    JPanel contPanel, firstPanel, secondPanel;
    JButton firstBtn, secondBtn;
    CardLayout cl;

TestmitCardLayout(){
    frame = new JFrame("Test mit CardLayout");
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    contPanel = new JPanel();
    firstPanel = new JPanel();
    secondPanel = new JPanel();
    firstBtn = new JButton("Gehe zum zweiten Fenster");
    secondBtn = new JButton("Gehe zum ersten Fenster");
    cl = new CardLayout(); // Wolke erstellt
    contPanel.setLayout(cl);

    firstPanel.setBackground(Color.RED);
    secondPanel.setBackground(Color.GREEN);

    firstPanel.add(firstBtn); // Buttons auf die Karten geklatscht.
    secondPanel.add(secondBtn);

    contPanel.add(firstPanel, "1");
    contPanel.add(secondPanel, "2");
    cl.show(contPanel, "1");

    firstBtn.addActionListener(e -> {
        cl.show(contPanel, "2");
    });

    secondBtn.addActionListener(e -> {
        cl.show(contPanel, "1");
    });

    frame.add(contPanel);
    frame.setVisible(true);
}

    public static void main(String[] args) {
    new TestmitCardLayout();
    }
}
