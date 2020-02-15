package de.thb.fbw.se.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

// // TODO: 15.02.2020 weitere Footer deelten

public class Availability extends JPanel
{
    JPanel headerPanelV = new JPanel(); // für den Header vom KundenMenue
    JLabel textHeaderVerfuegbarkeit = new JLabel("Verfügbarkeit");

    // Die Liste im Center
    private JTable cusTable;
    private DefaultTableModel cusModel;


    // -------
    // EAST bekommt ein Panel mit eigenem BorderLayout
    JPanel rechtsPanel = new JPanel();
    // Zurück-Button rechts unten
    JButton zurueckButton = new JButton("Zurück");
    // North vom rechtsPanel bekommt neues Panel mit Buttons: Anlegen, Bearbeiten, Löschen
    JPanel buttonPanel = new JPanel();
    // Buttons für das buttonPanel im rechtsPanel
    JButton anlegeButton = new JButton("Anlegen");
    JButton bearbeitenButton = new JButton("Bearbeiten");
    JButton entferneButton = new JButton("Löschen");

    CarRentalMainWindow mw;

    public Availability(CarRentalMainWindow mainWindow){
        mw = mainWindow;

        // Definition der Schriftart für den Header
        Font schriftartHeader = new Font("Serif", Font.PLAIN + Font.ITALIC, 40);
        // Schriftart & Größe der Buttons vom MainWindow.
        Font schriftartButtons = new Font("Arial", Font.PLAIN, 20);
        // Schriftart & Größe vom PanelLinks (Liste/Tabelle)
        Font schriftArtListe= new Font("Arial", Font.PLAIN, 20);

        // DESIGN! //

        // panelVerfuegbarkeitMenue Design
        setLayout(new BorderLayout());

        //headerKundenMenue
        textHeaderVerfuegbarkeit.setHorizontalAlignment(JLabel.CENTER);
        textHeaderVerfuegbarkeit.setVerticalAlignment(JLabel.CENTER);
        textHeaderVerfuegbarkeit.setFont(schriftartHeader); // legt die Schriftart fest.
        headerPanelV.setBackground(Color.GRAY);
        headerPanelV.setOpaque(true);


        // Table Links
        JPanel linksPanel = new JPanel();
        linksPanel.setLayout(new BorderLayout());

        String[] COLUMN_TITLE = new String[] {"Kundennummer", "Vorname", "Name", "Geburtsdatum", "Wohnort", "PLZ",
                "Straße"};

        DefaultTableModel cusModel = new DefaultTableModel(COLUMN_TITLE, 0){
            public boolean isCellEditable(int row, int column)
            {
                return true;
            }
        };

        cusModel.addRow(new Object[] {"0001","Christin", "Meier", "27.03.1989", "Brandenburg", "14770","Prühlitzer Straße 8"});
        cusModel.addRow(new Object[] {"0002","Mike","Müller", "22.07.1978", "Berlin", "10115", "Torstraße 5"});
        cusModel.addRow(new Object[] {"0003","Alex","Schulz", "12.01.1991", "Brandenburg", "14772", "Wilhelmsdorfer Straße 12"});
        cusModel.addRow(new Object[] {"0004","Luisa","Recknagel", "17.12.1995", "Potsdam", "14467", "Steinbeck Straße 3"});
        JTable cusTable = new JTable(cusModel);

        //cusTable.setFont(schriftArtListe);
        // PanelLinks + Table
        linksPanel.add(new JScrollPane(cusTable));

        // rechtsPanel
        rechtsPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout(3, 1));

        // Buttons rechts oben: anlegen, bearbeiten, hinzufügen.
        anlegeButton.setFont(schriftartButtons);
        anlegeButton.setPreferredSize(new Dimension(90, 50));
        bearbeitenButton.setFont(schriftartButtons);
        entferneButton.setFont(schriftartButtons);

        // Zurück-Button rechts unten
        zurueckButton.setFont(schriftartButtons);
        zurueckButton.setPreferredSize(new Dimension(90, 50));

        // Lambda Ausdruck für Back Funktionalität
        zurueckButton.addActionListener( e -> {
            mw.cl.show(mw.containerPanel, "RNTLMAIN");
        });
        anlegeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cusModel.addRow(createDataVector());

            }
        });
        bearbeitenButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // get selected row index
                JOptionPane.showMessageDialog(null,"Die Funktion steht zur Zeit nicht zur Verfügung!");

            }
        });

        entferneButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // get selected row index
                try {
                    int SelectedRowIndex = cusTable.getSelectedRow();
                    cusModel.removeRow(SelectedRowIndex);
                }catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Bitte wählen sie eine Zeile aus");
                }
            }
        });


        // ADDS
        headerPanelV.add(textHeaderVerfuegbarkeit);



        // Buttons rechts oben im buttonPanel: anlegen, bearbeiten, hinzufügen.
        buttonPanel.add(anlegeButton);
        buttonPanel.add(bearbeitenButton);
        buttonPanel.add(entferneButton);
        rechtsPanel.add(buttonPanel, BorderLayout.NORTH);
        rechtsPanel.add(zurueckButton, BorderLayout.SOUTH);

        add(headerPanelV, BorderLayout.NORTH);
        add(linksPanel, BorderLayout.CENTER);
        add(rechtsPanel, BorderLayout.EAST);
    }
    public static Vector createDataVector() {
        return null;
    }

}
