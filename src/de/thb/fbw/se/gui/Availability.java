package de.thb.fbw.se.gui;

import javax.swing.*;
import java.awt.*;

public class Availability extends JPanel
{
    JPanel headerPanelK = new JPanel(); // f�r den Header vom KundenMenue
    JLabel textHeaderKundenVerwaltung = new JLabel("Kundenverwaltung");
    JPanel footerPanel = new JPanel();  // f�r alle Menues
    JLabel textFooter = new JLabel(
            "Created by: Nico Zahmel, Christopher Alb, " + "Wilhelm W�hlte, Mirko Reefschl�ger, Torben Hammes");

    // Die Liste im Center
    JList list;
    JPanel linksPanel;
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
    CarRentalMainWindow mw;

    public Availability(CarRentalMainWindow mainWindow){

        mw = mainWindow;
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
        textHeaderKundenVerwaltung.setHorizontalAlignment(JLabel.CENTER);
        textHeaderKundenVerwaltung.setVerticalAlignment(JLabel.CENTER);
        textHeaderKundenVerwaltung.setFont(schriftartHeader); // legt die Schriftart fest.
        headerPanelK.setBackground(Color.GRAY);
        headerPanelK.setOpaque(true);

        // Liste Links
        linksPanel = new JPanel();
        linksPanel.setLayout(new BorderLayout());
        list = new JList(strSender);
        list.setFont(schriftArtListe);
        // PanelLinks + Liste zum Panel adden
        linksPanel.add(new JScrollPane(list));

        // rechtsPanel
        rechtsPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout(3, 1));

        

        // Zur�ck-Button rechts unten
        zurueckButton.setFont(schriftartButtons);
        zurueckButton.setPreferredSize(new Dimension(90, 50));

        // Lambda Ausdruck f�r Back Funktionalit�t
        zurueckButton.addActionListener( e -> {
            mw.cl.show(mw.containerPanel, "RNTLMAIN");
        });


        // ADDS
        headerPanelK.add(textHeaderKundenVerwaltung);



        // Buttons rechts oben im buttonPanel: anlegen, bearbeiten, hinzuf�gen.
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

        add(headerPanelK, BorderLayout.NORTH);
        add(linksPanel, BorderLayout.CENTER);
        add(rechtsPanel, BorderLayout.EAST);
        add(footerPanel, BorderLayout.SOUTH);
    }
}
