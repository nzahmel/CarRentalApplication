package de.thb.fbw.se.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;

public class CarManagement extends JPanel implements ActionListener {
    JPanel headerPanelA = new JPanel(); // für den Header AutoMenue
    JLabel textHeaderFahrzeugVerwaltung = new JLabel("Autoverwaltung");

    // Die Liste im Center

    //JTable flist;

    CarRentalMainWindow mw;
    private JTable carTable;
    private DefaultTableModel carModel;

    // Deklaration Variablen der Eingabemasken
    JLabel labFahrzeugID, labFahrzeugkategorie, labHersteller, labModell, labGetriebe, labKraftstoff, labKilometerstand;
    JRadioButton radioVerfuegbar, radioNichtVerfuegbar;
    JTextField txtID, txtModell, txtKilometerstand;
    JComboBox<String> wahlKategorie, wahlHersteller, wahlGetriebe, wahlKraftstoff;


    public CarManagement(CarRentalMainWindow mainWindow) {
       	mw = mainWindow;
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
        JButton speichernButton = new JButton("Speichern");
        JButton ladenButton = new JButton("Datensatz Laden");


     // Definition der Schriftart für den Header
        Font schriftartHeader = new Font("Serif", Font.PLAIN + Font.ITALIC, 40);
        // Schriftart & Größe der Buttons vom MainWindow.
        Font schriftartButtons = new Font("Arial", Font.PLAIN, 20);
        // Schriftart & Größe vom PanelLinks (Liste/Tabelle)
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

        // EingabeMaske
        JPanel linksPaneloben = new JPanel();
        linksPaneloben.setLayout(new BorderLayout());
        JPanel innen = new JPanel();
        linksPaneloben.add(innen, BorderLayout.CENTER);
        innen.setLayout(new GridLayout(8, 2));
        // Kontrollelemente erzeugen
        // Labels
        labFahrzeugID = new JLabel("Fahrzeug ID: ");
        labFahrzeugkategorie = new JLabel("Fahrzeugkategorie: ");
        labHersteller = new JLabel("Hersteller: ");
        labModell = new JLabel("Modell: ");
        labGetriebe = new JLabel("Getriebe: ");
        labKraftstoff = new JLabel("Kraftstoff: ");
        labKilometerstand = new JLabel("Kilometerstand: ");
        // Radio Elemente
        radioVerfuegbar = new JRadioButton("Verfügbar");
        radioNichtVerfuegbar = new JRadioButton("Nicht verfügbar");
        ButtonGroup grpVerfuegbarkeit = new ButtonGroup();
        grpVerfuegbarkeit.add(radioVerfuegbar);
        grpVerfuegbarkeit.add(radioNichtVerfuegbar);
        radioVerfuegbar.setSelected(true);

        // Eingabefelder
        txtID = new JTextField();
        txtModell = new JTextField();
        txtKilometerstand = new JTextField();

        // ComboBoxen
        String[] strKategorieWahl = {"Kleinstwagen" ,"Kleinwagen", "Kompaktklasse",
                "Mittelklasse", "Obere Mittelklasse", "Luxus", "Cabriolet", "SUV", "VAN"};
        wahlKategorie = new JComboBox<String>(strKategorieWahl);

        String[] strHerstellerWahl = {"Mercedes-Benz" ,"BMW", "Volkswagen",
                "Audi", "Ford", "Porsche", "Opel", "9ff", "Abarth" ,"AC", "Acura",
                "Aixam", "Alfa Romeo", "Alpina", "Alpine", "Amphicar", "Ariel Motor" ,"Artega", "Aspid",
                "Aston Martin", "Austin", "Autobianchi", "Auverland", "Baic", "Bedford" ,"Bellier", "Bentley",
                "Bolloré", "Borgward", "Brilliance", "Bugatti", "Buick", "BYD" ,"Cadillac", "Caravans-Wohnm",
                "Casalini", "Caterham", "Changhe", "Chatenet", "Chery", "Chevrolet" ,"Chrysler", "Citroen",
                "CityEL", "CMC", "Corvette", "Cupra", "Dacia", "Daewoo" ,"Daimler", "Dangel",
                "De la Chapelle", "De Tomaso", "Derways", "DSK", "Dodge", "Donkervoort" ,"DR Motor", "DS Automobiles",
                "Dutton", "e.GO", "Estrima", "Ferrari", "Fiat", "Fisker" ,"Gac Gonow", "Galloper",
                "GAZ", "GEM", "GEMBALLA", "Gillet", "Giotti Victoria", "GMC" ,"Goupil", "Great Wall",
                "Grevac", "Haima", "Haval", "Honda", "HUMMER", "Hurtan" ,"Hyundai", "Infiniti",
                "Innocenti", "Iso Rivolta", "Isuzu", "Iveco", "IZH", "Jaguar","Mazda"};
        wahlHersteller = new JComboBox<String>(strHerstellerWahl);

        String[] strGetriebeWahl = {"Manuell" ,"Automatik"};
        wahlGetriebe = new JComboBox<String>(strGetriebeWahl);

        String[] strKraftstoffWahl = {"Benzin" ,"Diesel", "Strom"};
        wahlKraftstoff = new JComboBox<String>(strKraftstoffWahl);

        // Zusammenbau aller Elemente
        innen.add(labFahrzeugID);
        innen.add(txtID);
        // Line 2
        innen.add(labFahrzeugkategorie);
        innen.add(wahlKategorie);
        // Line 3
        innen.add(labHersteller);
        innen.add(wahlHersteller);
        // Line 4
        innen.add(labModell);
        innen.add(txtModell);
        // Line 5
        innen.add(labGetriebe);
        innen.add(wahlGetriebe);
        // Line 6
        innen.add(labKraftstoff);
        innen.add(wahlKraftstoff);
        // Line 7
        innen.add(labKilometerstand);
        innen.add(txtKilometerstand);
        innen.add(radioVerfuegbar);
        innen.add(radioNichtVerfuegbar);

        // Table Links
        JPanel linksPanelunten = new JPanel();
        linksPanelunten.setLayout(new BorderLayout());

        // Maske + Table Links
        JPanel linksPanel = new JPanel();
        linksPanel.setLayout(new BorderLayout());

        String[] COLUMN_TITLE = new String[] {"ID", "Fahrzeugkategorie", "Hersteller", "Modell", "Getriebe", "Kraftstoff",
        		"Kilometerstand", "Verfügbarkeit"};
       
        DefaultTableModel carModel = new DefaultTableModel(COLUMN_TITLE, 0){
        			public boolean isCellEditable(int row, int column)
        			{
        				return false;
        			}
        		};
        carModel.addRow(new Object[] {"1","Mittelklasse","BMW", "e46 3er", "manuell", "Benzin", "200"});
        carModel.addRow(new Object[] {"2","Luxus","Mercedes-Benz", "C36 AMG", "manuell", "Benzin", "1000"});
        carModel.addRow(new Object[] {"3","Kompaktklasse","Mazda", "mx 5", "Manuell", "Diesel", "200"});
        carModel.addRow(new Object[] {"4","Mittelkalsse","Tesla", "Modell 3", "Automatik", "Strom", "2500"});
        JTable carTable = new JTable(carModel);
               
        // PanelLinks -> Maske & Table
        linksPanel.add(linksPaneloben, BorderLayout.NORTH);
        linksPanelunten.add(new JScrollPane(carTable));
        linksPanel.add(linksPanelunten, BorderLayout.SOUTH);
        
        // rechtsPanel
        rechtsPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout(5, 1));

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
				if(!txtID.getText().trim().equals("")) {
				carModel.addRow(new Object[]{txtID.getText(), wahlKategorie.getSelectedItem().toString(),
						wahlHersteller.getSelectedItem().toString(),txtModell.getText(),wahlGetriebe.getSelectedItem().toString()
						,wahlKraftstoff.getSelectedItem().toString(),txtKilometerstand.getText(),radioNichtVerfuegbar.getSelectedObjects()});
				
				}else {
					JOptionPane.showMessageDialog(null,"Die ID darf nicht Leer sein");	
				}
			}
		});
       bearbeitenButton.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			// berarbeiten der Daten möglich
			if(carTable.getSelectedRow()==-1) {
				if(carTable.getRowCount()==0) {
					JOptionPane.showMessageDialog(null,"Tabelle ist leer.");	
				}else {
					JOptionPane.showMessageDialog(null,"Sie müssen ein Fahrzeug auswählen.");
				}
			}else {
				carModel.setValueAt(txtID.getText(), carTable.getSelectedRow(), 0);
				carModel.setValueAt(wahlKategorie.getSelectedItem().toString(), carTable.getSelectedRow(), 1);
				carModel.setValueAt(wahlHersteller.getSelectedItem().toString(), carTable.getSelectedRow(), 2);
				carModel.setValueAt(txtModell.getText(), carTable.getSelectedRow(), 3);
				carModel.setValueAt(wahlGetriebe.getSelectedItem().toString(), carTable.getSelectedRow(), 4);
				carModel.setValueAt(wahlKraftstoff.getSelectedItem().toString(), carTable.getSelectedRow(), 5);
				carModel.setValueAt(txtKilometerstand.getText(), carTable.getSelectedRow(), 6);
			
			
				//JOptionPane.showMessageDialog(null,"Die Funktion steht zur Zeit nicht zur Verfügung!");
			}
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
				JOptionPane.showMessageDialog(null,"Bitte wählen sie eine Zeile aus.");
			}
		}
       	});
       
       	carTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				txtID.setText(carModel.getValueAt(carTable.getSelectedRow(),0).toString());
				wahlKategorie.setSelectedItem(carModel.getValueAt(carTable.getSelectedRow(),1).toString());
				wahlHersteller.setSelectedItem(carModel.getValueAt(carTable.getSelectedRow(),2).toString());
				txtModell.setText(carModel.getValueAt(carTable.getSelectedRow(),3).toString());
				wahlGetriebe.setSelectedItem(carModel.getValueAt(carTable.getSelectedRow(),4).toString());
				wahlKraftstoff.setSelectedItem(carModel.getValueAt(carTable.getSelectedRow(),5).toString());
				txtKilometerstand.setText(carModel.getValueAt(carTable.getSelectedRow(),6).toString());
				
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
    	   
       
    	   
       

        // ADDS
        headerPanelA.add(textHeaderFahrzeugVerwaltung);



        // Buttons rechts oben im buttonPanel: anlegen, bearbeiten, hinzufügen.
        buttonPanel.add(anlegeButton);
        buttonPanel.add(bearbeitenButton);
        buttonPanel.add(entferneButton);
        rechtsPanel.add(buttonPanel, BorderLayout.NORTH);
        rechtsPanel.add(zurueckButton, BorderLayout.SOUTH);


        add(headerPanelA, BorderLayout.NORTH);
        add(linksPanel, BorderLayout.CENTER);
        add(rechtsPanel, BorderLayout.EAST);
            }



	public static Vector createDataVector() {
    	return null;

    }




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	}





