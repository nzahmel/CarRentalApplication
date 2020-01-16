package de.thb.fbw.se.gui;

import javax.swing.*;
import java.awt.*;

public class CarManagement extends JPanel {
    JPanel headerPanelA = new JPanel(); // für den Header AutoMenue
    JLabel textHeaderFahrzeugVerwaltung = new JLabel("Autoverwaltung");

    CarManagement(){
        // Definition der Schriftart für den Header
        Font schriftartHeader = new Font("Serif", Font.PLAIN + Font.ITALIC, 40);
        // Schriftart & Größe der Buttons vom MainWindow.
        Font schriftartButtons = new Font("Arial", Font.PLAIN, 20);
        // Schriftart & Größe vom PanelLinks (Liste/Tabelle)
        Font schriftArtListe= new Font("Arial", Font.PLAIN, 20);

        // DESIGN! //

        // panelAutoverwaltungMenue Design
        setLayout(new BorderLayout());

        // headerAutoMenue
        textHeaderFahrzeugVerwaltung.setHorizontalAlignment(JLabel.CENTER);
        textHeaderFahrzeugVerwaltung.setVerticalAlignment(JLabel.CENTER);
        textHeaderFahrzeugVerwaltung.setFont(schriftartHeader); // legt die Schriftart fest.
        headerPanelA.setBackground(Color.GRAY);
        headerPanelA.setOpaque(true);
        headerPanelA.add(textHeaderFahrzeugVerwaltung);
        add(headerPanelA, BorderLayout.NORTH);
    }
}
