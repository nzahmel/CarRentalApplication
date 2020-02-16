package de.thb.fbw.se.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

// // TODO: 15.02.2020 Main Header Panel Redundanz aufheben!

public class CustomerManagement extends JPanel{
    JPanel headerPanelK = new JPanel(); // f�r den Header vom KundenMenue
    JLabel textHeaderKundenVerwaltung = new JLabel("Kundenverwaltung");


    // Die Liste im Center
    private JTable cusTable;
    private DefaultTableModel cusModel;

    // Deklaration Variablen der Eingabemasken
    JLabel labKundennummer, labVorname, labNachname, labGeburtsdatum, labWohnort, labPLZ, labStra�e;
    JTextField txtKN, txtVorn, txtNachn, txtGeb, txtWohn, txtPLZ, txtStra�e ;
    

    CarRentalMainWindow mw;

    public CustomerManagement(CarRentalMainWindow mainWindow){
        mw = mainWindow;
/*      mw.remove(mw.textHeaderMainMenue);
        mw.add(textHeaderKundenVerwaltung);*/
        
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
        JButton speichernButton = new JButton("Speichern");
        JButton ladenButton = new JButton("Laden");

        // Definition der Schriftart f�r den Header
        Font schriftartHeader = new Font("Serif", Font.PLAIN + Font.ITALIC, 40);
        // Schriftart & Gr��e der Buttons vom MainWindow.
        Font schriftartButtons = new Font("Arial", Font.PLAIN, 20);
        // Schriftart & Gr��e vom PanelLinks (Liste/Tabelle)
        Font schriftArtListe= new Font("Arial", Font.PLAIN, 20);

        // DESIGN! //
        
     // EingabeMaske
        JPanel linksPaneloben = new JPanel();
        linksPaneloben.setLayout(new BorderLayout());
        JPanel innen = new JPanel();
        linksPaneloben.add(innen, BorderLayout.CENTER);
        innen.setLayout(new GridLayout(8, 2));
        // Kontrollelemente erzeugen
        // Labels
        labKundennummer = new JLabel("Kundennummer: ");
        labVorname = new JLabel("Vorname: ");
        labNachname = new JLabel("Nachname: ");
        labGeburtsdatum = new JLabel("Geburtsdatum: ");
        labWohnort = new JLabel("Wohnort: ");
        labPLZ = new JLabel("PLZ: ");
        labStra�e = new JLabel("Stra�e: ");
        
        // Eingabefelder
        txtKN = new JTextField();
        txtVorn = new JTextField();
        txtNachn = new JTextField();
        txtGeb = new JTextField();
        txtWohn = new JTextField();
        txtPLZ = new JTextField();
        txtStra�e = new JTextField();

        
        // Zusammenbau aller Elemente
        innen.add(labKundennummer);
        innen.add(txtKN);
        // Line 2
        innen.add(labVorname);
        innen.add(txtVorn);
        // Line 3
        innen.add(labNachname);
        innen.add(txtNachn);
        // Line 4
        innen.add(labGeburtsdatum);
        innen.add(txtGeb);
        // Line 5
        innen.add(labWohnort);
        innen.add(txtWohn);
        // Line 6
        innen.add(labPLZ);
        innen.add(txtPLZ);
        // Line 7
        innen.add(labStra�e);
        innen.add(txtStra�e);
       
        // Table Links
        JPanel linksPanelunten = new JPanel();
        linksPanelunten.setLayout(new BorderLayout());

        // panelKundenverwaltungMenue Design
        setLayout(new BorderLayout());

        //headerKundenMenue
        textHeaderKundenVerwaltung.setHorizontalAlignment(JLabel.CENTER);
        textHeaderKundenVerwaltung.setVerticalAlignment(JLabel.CENTER);
        textHeaderKundenVerwaltung.setFont(schriftartHeader); // legt die Schriftart fest.
        headerPanelK.setBackground(Color.GRAY);
        headerPanelK.setOpaque(true);


        // Table Links
        JPanel linksPanel = new JPanel();
        linksPanel.setLayout(new BorderLayout());

        String[] COLUMN_TITLE = new String[] {"Kundennummer", "Vorname", "Name", "Geburtsdatum", "Wohnort", "PLZ",
        		"Stra�e"};

        DefaultTableModel cusModel = new DefaultTableModel(COLUMN_TITLE, 0){
        			public boolean isCellEditable(int row, int column)
        			{
        				return true;
        			}
        		};

        cusModel.addRow(new Object[] {"0001","Christin", "Meier", "27.03.1989", "Brandenburg", "14770","Pr�hlitzer Stra�e 8"});
        cusModel.addRow(new Object[] {"0002","Mike","M�ller", "22.07.1978", "Berlin", "10115", "Torstra�e 5"});
        cusModel.addRow(new Object[] {"0003","Alex","Schulz", "12.01.1991", "Brandenburg", "14772", "Wilhelmsdorfer Str.12"});
        cusModel.addRow(new Object[] {"0004","Luisa","Recknagel", "17.12.1995", "Potsdam", "14467", "Steinbeck Stra�e 3"});
        JTable cusTable = new JTable(cusModel);

        
     // PanelLinks -> Maske & Table
        linksPanel.add(linksPaneloben, BorderLayout.NORTH);
        linksPanelunten.add(new JScrollPane(cusTable));
        linksPanel.add(linksPanelunten, BorderLayout.SOUTH);
        
        // rechtsPanel
        rechtsPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout(5, 1));

        // Buttons rechts oben: anlegen, bearbeiten, hinzuf�gen.
        anlegeButton.setFont(schriftartButtons);
        anlegeButton.setPreferredSize(new Dimension(90, 50));
        bearbeitenButton.setFont(schriftartButtons);
        entferneButton.setFont(schriftartButtons);
        speichernButton.setFont(schriftartButtons);
        ladenButton.setFont(schriftartButtons);

        // Zur�ck-Button rechts unten
        zurueckButton.setFont(schriftartButtons);
        zurueckButton.setPreferredSize(new Dimension(90, 50));

        // Lambda Ausdruck f�r Back Funktionalit�t
        zurueckButton.addActionListener( e -> {
            mw.cl.show(mw.containerPanel, "RNTLMAIN");
        });
        anlegeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(!txtKN.getText().trim().equals("")) {
				cusModel.addRow(new Object[]{txtKN.getText(), txtVorn.getText(),
						 txtNachn.getText(), txtGeb.getText(), txtWohn.getText()
						, txtPLZ.getText(), txtStra�e.getText()});
				//Inhalt wird gel�scht
				txtKN.setText("");
				txtVorn.setText("");
				txtNachn.setText("");
				txtGeb.setText("");
				txtWohn.setText("");
				txtPLZ.setText("");
				txtStra�e.setText("");
			
				}else {
					JOptionPane.showMessageDialog(null,"Die Kundennummer darf nicht Leer sein");	
				}
			}
		});
       bearbeitenButton.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			// berarbeiten der Daten m�glich
			if(cusTable.getSelectedRow()==-1) {
				if(cusTable.getRowCount()==0) {
					JOptionPane.showMessageDialog(null,"Tabelle ist leer.");	
				}else {
					JOptionPane.showMessageDialog(null,"Sie m�ssen einen Kunden ausw�hlen.");
				}
			}else {
				cusModel.setValueAt(txtKN.getText(), cusTable.getSelectedRow(), 0);
				cusModel.setValueAt(txtVorn.getText(), cusTable.getSelectedRow(), 1);
				cusModel.setValueAt(txtNachn.getText(), cusTable.getSelectedRow(), 2);
				cusModel.setValueAt(txtGeb.getText(), cusTable.getSelectedRow(), 3);
				cusModel.setValueAt(txtWohn.getText(), cusTable.getSelectedRow(), 4);
				cusModel.setValueAt(txtPLZ.getText(), cusTable.getSelectedRow(), 5);
				cusModel.setValueAt(txtStra�e.getText(), cusTable.getSelectedRow(), 6);
				
				
				
				//Inhalt wird gel�scht 
				txtKN.setText("");
				txtVorn.setText("");
				txtNachn.setText("");
				txtGeb.setText("");
				txtWohn.setText("");
				txtPLZ.setText("");
				txtStra�e.setText("");
			
			
				//JOptionPane.showMessageDialog(null,"Die Funktion steht zur Zeit nicht zur Verf�gung!");
			}
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
				JOptionPane.showMessageDialog(null,"Bitte w�hlen sie eine Zeile aus.");
			}
		}
       	});
       
       	cusTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				txtKN.setText(cusModel.getValueAt(cusTable.getSelectedRow(),0).toString());
				txtVorn.setText(cusModel.getValueAt(cusTable.getSelectedRow(),1).toString());
				txtNachn.setText(cusModel.getValueAt(cusTable.getSelectedRow(),2).toString());
				txtGeb.setText(cusModel.getValueAt(cusTable.getSelectedRow(),3).toString());
				txtWohn.setText(cusModel.getValueAt(cusTable.getSelectedRow(),4).toString());
				txtPLZ.setText(cusModel.getValueAt(cusTable.getSelectedRow(),5).toString());
				txtStra�e.setText(cusModel.getValueAt(cusTable.getSelectedRow(),6).toString());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
       		
       	});
       	
       	speichernButton.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent e) {
    			try {
    			//Hier den Pfad angeben wo sie die Textdatei gespeichert haben + Dateiname mit Dateiendung
    			File file = new File("C:\\Users\\wiwo9\\git\\CarRentalApplication\\src\\de\\thb\\fbw\\se\\gui\\Kundenliste");
    			if(!file.exists()) {
    				file.createNewFile();
    				
    			}
    			
    			FileWriter fw = new FileWriter(file.getAbsoluteFile());
    			BufferedWriter bw = new BufferedWriter(fw);
    			
    			for(int i = 0; i < cusTable.getRowCount(); i++) {
    				for(int j = 0; j < cusTable.getColumnCount(); j++) {
    					bw.write((String)cusTable.getModel().getValueAt(i, j) + " ");
    				}
    				bw.write("\r\n");
    			}
    			bw.close();
    			fw.close();
    			JOptionPane.showMessageDialog(null, " Die Tabelle wurde gespeichert.");
    			
    			}catch(Exception ex){
    				JOptionPane.showMessageDialog(null, " Datei konnte nicht gefunden werden. Bitte �berpr�fen sie den Dateipfad.");
    				
    			}
    		}
    		}); 
       	
       	ladenButton.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// Hier den Pfad angeben von wo sie die Textdatei laden m�chten + Dateiname mit Dateiendung
    			String filePath = "C:\\Users\\wiwo9\\git\\CarRentalApplication\\src\\de\\thb\\fbw\\se\\gui\\Kundenliste";
    			File file = new File(filePath);
    			
    			try {
    				//l�scht den Inhalt bevor er den neuen Inhalt l�dt
    				cusModel.setRowCount(0);
    				//Hier l�dt er das File
    				BufferedReader br = new BufferedReader(new FileReader(file));
    				Object[] tableLines = br.lines().toArray();
    				
    				for(int i = 0; i < tableLines.length; i++)
    				{
    					String line = tableLines[i].toString().trim();
    					String[] dataRow = line.split(" ");
    					cusModel.addRow(dataRow);
    				}
    				
    			}catch(Exception ex){
    				JOptionPane.showMessageDialog(null, " Die Datei wurde nicht gefunden.");
    			}
    			
    		}
    	});


        // ADDS
        headerPanelK.add(textHeaderKundenVerwaltung);



        // Buttons rechts oben im buttonPanel: anlegen, bearbeiten, hinzuf�gen.
        buttonPanel.add(anlegeButton);
        buttonPanel.add(bearbeitenButton);
        buttonPanel.add(entferneButton);
        rechtsPanel.add(buttonPanel, BorderLayout.NORTH);
        rechtsPanel.add(zurueckButton, BorderLayout.SOUTH);

        add(headerPanelK, BorderLayout.NORTH);
        add(linksPanel, BorderLayout.CENTER);
        add(rechtsPanel, BorderLayout.EAST);
        
    



        // Buttons rechts oben im buttonPanel: anlegen, bearbeiten, hinzuf�gen.
        buttonPanel.add(anlegeButton);
        buttonPanel.add(bearbeitenButton);
        buttonPanel.add(entferneButton);
        buttonPanel.add(speichernButton);
        buttonPanel.add(ladenButton);
        rechtsPanel.add(buttonPanel, BorderLayout.NORTH);
        rechtsPanel.add(zurueckButton, BorderLayout.SOUTH);


        add(headerPanelK, BorderLayout.NORTH);
        add(linksPanel, BorderLayout.CENTER);
        add(rechtsPanel, BorderLayout.EAST);
            
    }
    
    public static Vector createDataVector() {
    	return null;
    }

}
