package de.thb.fbw.se.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;

public class CarManagement extends JPanel implements ActionListener {
    JPanel headerPanelA = new JPanel(); // f�r den Header AutoMenue
    JLabel textHeaderFahrzeugVerwaltung = new JLabel("Autoverwaltung");
    JPanel footerPanel = new JPanel();  // f�r alle Menues
    JLabel textFooter = new JLabel(
            "Created by: Nico Zahmel, Christopher Alb, " + "Wilhelm W�hlte, Mirko Reefschl�ger, Torben Hammes");

    // Die Liste im Center
	//JTable table;
    
    private JTable carTable;
    private DefaultTableModel carModel;
    
    public CarManagement() {
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

        // Table Links
        JPanel linksPanel = new JPanel();
        linksPanel.setLayout(new BorderLayout());
        
        String[] COLUMN_TITLE = new String[] {"ID", "Fahrzeugkategorie", "Hersteller", "Modell", "Getriebe", "Kraftstoff",
        		"Kilometerstand"};
       
        DefaultTableModel carModel = new DefaultTableModel(COLUMN_TITLE, 0){
        			public boolean isCellEditable(int row, int column)
        			{
        				return true;
        			}
        		};
        
        carModel.addRow(new Object[] {"1","PKW","BMW", "e46 3er", "manuell", "Benzin", "200"});
        carModel.addRow(new Object[] {"2","PKW","Mercedes", "C36 AMG", "manuell", "Benzin", "1000"});
        carModel.addRow(new Object[] {"3","PKW","Mazda", "mx 5", "manuell", "Diesel", "200"});
        carModel.addRow(new Object[] {"4","PKW","Tesla", "Modell 3", "automatik", "Strom", "2500"});
        JTable carTable = new JTable(carModel);
       
        
        //flist = new JTable(new FahrzeugTable(fahrzeugverwaltung));
        //flist = new JTable(data, COLUMN_TITLES);
        //flist.setFont(schriftArtListe);
        
        // PanelLinks + Liste
        linksPanel.add(new JScrollPane(carTable));
        
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
        anlegeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				carModel.addRow(createDataVector());
				
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
			int SelectedRowIndex = carTable.getSelectedRow();
			carModel.removeRow(SelectedRowIndex);
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"Bitte w�hlen sie eine Zeile aus.");
			}
		}
	});
       
        // ADDS
        headerPanelA.add(textHeaderFahrzeugVerwaltung);

        

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
        
        
  
	public static Vector createDataVector() {
    	return null;
    	
    }
    
    
	
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	} 
	  	
     
	
	
