package de.thb.fbw.se.gui;

import javax.swing.*;
import java.awt.*;

public class CarManagement extends JPanel {
    JPanel headerPanelA = new JPanel(); // f�r den Header AutoMenue
    JLabel textHeaderFahrzeugVerwaltung = new JLabel("Autoverwaltung");
    JPanel footerPanel = new JPanel();  // f�r alle Menues
    JLabel textFooter = new JLabel(
            "Created by: Nico Zahmel, Christopher Alb, " + "Wilhelm W�hlte, Mirko Reefschl�ger, Torben Hammes");

    // Die Liste im Center
    JList list;
    JPanel linksPanel = new JPanel();
    String[] strSender = {"Auto 1", "Auto2", "Auto3", "Auto4", "Auto5", "Auto6", "Auto7", "Auto8"
            , "Auto2", "Auto3", "Auto4", "Auto5", "Auto6", "Auto7", "Auto8"
            , "Auto2", "Auto3", "Auto4", "Auto5", "Auto6", "Auto7", "Auto8"
            , "Auto2", "Auto3", "Auto4", "Auto5", "Auto6", "Auto7", "Auto8"
            , "Auto2", "Auto3", "Auto4", "Auto5", "Auto6", "Auto7", "Auto8"
    };

    // -------
    // EAST bekommt ein Panel mit eigenem BorderLayout
    JPanel rechtsPanel = new JPanel();
    // Zur�ck-Button rechts unten
    JButton zurueckButton = new JButton("Zur�ck");
    // North vom rechtsPanel bekommt neues Panel mit Buttons: Anlegen, Bearbeiten, L�schen
    JPanel buttonPanel = new JPanel();
    // Buttons f�r das buttonPanel im rechtsPanel
    JButton anlegeButton = new JButton("Anlegen");
    JButton bearbeitenButton = new JButton("Bearbeiten");
    JButton entferneButton = new JButton("L�schen");

    public CarManagement(){

        // Definition der Schriftart f�r den Header
        Font schriftartHeader = new Font("Serif", Font.PLAIN + Font.ITALIC, 40);
        // Schriftart & Gr��e der Buttons vom MainWindow.
        Font schriftartButtons = new Font("Arial", Font.PLAIN, 20);
        // Schriftart & Gr��e vom PanelLinks (Liste/Tabelle)
        Font schriftArtListe= new Font("Arial", Font.PLAIN, 20);

        // DESIGN! //

        // panelKundenverwaltungMenue Design
        setLayout(new BorderLayout());

        //headerKundenMenue
        textHeaderFahrzeugVerwaltung.setHorizontalAlignment(JLabel.CENTER);
        textHeaderFahrzeugVerwaltung.setVerticalAlignment(JLabel.CENTER);
        textHeaderFahrzeugVerwaltung.setFont(schriftartHeader); // legt die Schriftart fest.
        headerPanelA.setBackground(Color.GRAY);
        headerPanelA.setOpaque(true);

        // Liste Links
        linksPanel.setLayout(new BorderLayout());
        list = new JList(strSender);
        list.setFont(schriftArtListe);

        // rechtsPanel
        rechtsPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout(3, 1));

        // Buttons rechts oben: anlegen, bearbeiten, hinzuf�gen.
        anlegeButton.setFont(schriftartButtons);
        anlegeButton.setPreferredSize(new Dimension(90, 50));
        bearbeitenButton.setFont(schriftartButtons);
        entferneButton.setFont(schriftartButtons);

        // Zur�ck-Button rechts unten
        zurueckButton.setFont(schriftartButtons);
        zurueckButton.setPreferredSize(new Dimension(90, 50));

        // Lambda Ausdruck f�r Back Funktionalit�t
        zurueckButton.addActionListener( e -> {
            CarRentalMainWindow.cl.show(CarRentalMainWindow.containerPanel, "RNTLMAIN");
        });


        // ADDS
        headerPanelA.add(textHeaderFahrzeugVerwaltung);

        // PanelLinks + Liste
        linksPanel.add(new JScrollPane(list));
        //linksPanel.add(list, BorderLayout.CENTER);

        // Buttons rechts oben im buttonPanel: anlegen, bearbeiten, hinzuf�gen.
        buttonPanel.add(anlegeButton);
        buttonPanel.add(bearbeitenButton);
        buttonPanel.add(entferneButton);
        rechtsPanel.add(buttonPanel, BorderLayout.NORTH);
        rechtsPanel.add(zurueckButton, BorderLayout.SOUTH);

        // Footer
        // Definition der Schriftart Footer
        Font schriftartFooter = new Font("Serif", Font.PLAIN + Font.ITALIC, 20);
        textFooter.setFont(schriftartFooter); // legt die Schriftart fest.
        // Das Zentrum des Geschehens - f�gt den Text hinzu & platziert ihn im footerPanel
        footerPanel.add(textFooter); // f�gt das Text-Label unten hinzu.
        footerPanel.setBackground(Color.RED);
        footerPanel.add(textFooter);

        add(headerPanelA, BorderLayout.NORTH);
        add(linksPanel, BorderLayout.CENTER);
        add(rechtsPanel, BorderLayout.EAST);
        add(footerPanel, BorderLayout.SOUTH);
    }
}
