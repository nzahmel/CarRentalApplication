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
    JPanel headerPanelV = new JPanel(); // f�r den Header vom KundenMenue
    JLabel textHeaderVerfuegbarkeit = new JLabel("Verf�gbarkeit");

    // Die Liste im Center
    private JTable cusTable;
    private DefaultTableModel cusModel;


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

        String[] COLUMN_TITLE = new String[] {"Kundennummer", "Vorname", "Name", "ID", "Hersteller", "Leihdauer",
                "Telefonnummer"};

        DefaultTableModel cusModel = new DefaultTableModel(COLUMN_TITLE, 0){
            public boolean isCellEditable(int row, int column)
            {
                return true;
            }
        };

        cusModel.addRow(new Object[] {"0001","Christin", "Meier", "1", "BMW", "10 Tage","01624581669"});
        cusModel.addRow(new Object[] {"0002","Mike","M�ller", "2", "Mercedes-Benz", "2 Tage", "015258916603"});
        
        JTable cusTable = new JTable(cusModel);

        //cusTable.setFont(schriftArtListe);
        // PanelLinks + Table
        linksPanel.add(new JScrollPane(cusTable));

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
                JOptionPane.showMessageDialog(null,"Die Funktion steht zur Zeit nicht zur Verf�gung!");

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
                    JOptionPane.showMessageDialog(null,"Bitte w�hlen sie eine Zeile aus");
                }
            }
        });


        // ADDS
        headerPanelV.add(textHeaderVerfuegbarkeit);



        // Buttons rechts oben im buttonPanel: anlegen, bearbeiten, hinzuf�gen.
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
