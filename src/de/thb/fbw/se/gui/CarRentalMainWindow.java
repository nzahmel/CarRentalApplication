/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// TODO: 09.01.2020 Package-Namen anpassen.
package de.thb.fbw.se.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import fahrzeugverwaltung.Fahrzeug;
import fahrzeugverwaltung.Fahrzeugverwaltung;
import fahrzeugverwaltung.IFahrzeugverwaltung;

/**
 *
 * @author Nico Zahmel <Enjoy the flight>
 * @version 1.0 image source: <a href=
 *          "https://www.freepik.com/free-photos-vectors/background">Background
 *          vector created by rawpixel.com - www.freepik.com</a>
 */

public class CarRentalMainWindow extends JFrame {
	// Variablendeklaration

	JPanel panelMainMenue = new JPanel();	// Erstellung der Arbeitsflaeche des Hauptmenue-Fensters
	JPanel panelKundenverwaltungMenue  = new CustomerManagement(); //new JPanel(); // Erstellung des KDVW Menues
	JPanel panelAutoverwaltungMenue = new CarManagement(fv);	// Erstellung des AUVW Menues
	CardLayout cl = new CardLayout();
	JPanel containerPanel = new JPanel();


	JPanel headerPanelM = new JPanel(); // für das MainMenue
	JPanel buttonPanelM = new JPanel(); // für das MainMenue
	Box buttonPanelMLinks = Box.createVerticalBox(); // ButtonPanelMainLinks
	Box buttonPanelMRechts = Box.createVerticalBox(); // ButtonPanelMainRechts
	JPanel footerPanel = new JPanel();  // für alle Menues

	JLabel textHeaderMainMenue = new JLabel("Verwaltungsprogramm v 1.0");
	JLabel textFooter = new JLabel(
			"Created by: Nico Zahmel, Christopher Alb, " + "Wilhelm Wöhlte, Mirko Reefschläger, Torben Hammes");

	JButton bCustomerManagement = new JButton(" Kundenverwaltung  ");
	JButton bCarManagement = new JButton("Fahrzeugverwaltung");
	JButton bVerfuegbarkeit = new JButton("    Verfügbarkeit      ");

	// Definition der Schriftart für den Header
	Font schriftartHeader = new Font("Serif", Font.PLAIN + Font.ITALIC, 40);

	// Schriftart & Größe der Buttons vom MainWindow.
	Font schriftartButtons = new Font("Arial", Font.PLAIN, 20);

	// KONSTRUKTOR!
	public CarRentalMainWindow() {
		/*
		 * Initialisierung & Anpassung JFrame & Title
		 */
		setTitle("Car Rental System for S.E. at THB");
		setSize(1024, 768);
		setLocationRelativeTo(null); // zentriert das Fenster in die Mitte,
		// muss nach pack() oder setSize ausgefuehrt werden!
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		* Dies ist der Hauptcontainer, in dem alle Menues in Form von Karten (einzelnen Panels) angelegt werden.
		*/
		containerPanel.setLayout(cl);


		/////////////////////////////////////////////////////////////////////////////////////

		/*
		  Style + Adds der Elemente der Seiten:
		 */

									// <<<<<< Verwaltung MainMenue >>>>>>>

		// Content-Panel vom MainMenue
		panelMainMenue.setLayout(new BorderLayout());

		// headerMainMenue
		textHeaderMainMenue.setHorizontalAlignment(JLabel.CENTER);
		textHeaderMainMenue.setVerticalAlignment(JLabel.CENTER);
		textHeaderMainMenue.setFont(schriftartHeader); // legt die Schriftart fest.
		headerPanelM.setBackground(Color.GRAY);
		headerPanelM.setOpaque(true);
		headerPanelM.add(textHeaderMainMenue);

		// Die Mitte 'center' bekommt ein Panel für die Buttons
		buttonPanelM.setLayout(new GridLayout(1, 2));
		Border border = BorderFactory.createLineBorder(Color.BLACK); 	// Black Border um das ButtonPanel
		buttonPanelM.setBorder(border);

				/*
		Buttons MAINMENUE
		 */

		// Zuweisung der Attribute der Buttons von MainMenue
		bCarManagement.setFont(schriftartButtons);
		bCustomerManagement.setFont(schriftartButtons);
		bVerfuegbarkeit.setFont(schriftartButtons);
		bCustomerManagement.setPreferredSize(new Dimension(100, 100));
		bCarManagement.setPreferredSize(new Dimension(100, 100));
		bVerfuegbarkeit.setPreferredSize(new Dimension(100, 100));


		// Linkes ButtonPanel

		buttonPanelMLinks.add(Box.createVerticalGlue());
		buttonPanelMLinks.add(bCustomerManagement);
		buttonPanelMLinks.add(Box.createVerticalGlue());
		buttonPanelMLinks.add(bCarManagement);
		buttonPanelMLinks.add(Box.createVerticalGlue());
		buttonPanelMLinks.add(bVerfuegbarkeit);
		buttonPanelMLinks.add(Box.createVerticalGlue());
		buttonPanelM.add(buttonPanelMLinks);


		// TODO: 09.01.2020 Initialisierung Buttons 1. Menue "Kundenverwaltung": hinz, loesch, bearb

		/*
		 * Einbindung vom Image mit einem JLabel MainMenue
		 */
		JLabel jl = new JLabel();
		jl.setIcon(new ImageIcon("image/autoklein.png"));
		jl.setPreferredSize(new Dimension(500, 350));
		jl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 200));
		buttonPanelMRechts.add(Box.createVerticalGlue());
		buttonPanelMRechts.add(jl);
		buttonPanelMRechts.add(Box.createVerticalGlue());
		//validate();

		buttonPanelM.add(buttonPanelMRechts);

		// FINAL ADDS:
		panelMainMenue.add(headerPanelM, BorderLayout.NORTH);
		panelMainMenue.add(buttonPanelM, BorderLayout.CENTER);
		panelMainMenue.add(footerPanel, BorderLayout.SOUTH);

		containerPanel.add(panelMainMenue, "RNTLMAIN");
		cl.show(containerPanel, "RNTLMAIN");
		containerPanel.add(panelKundenverwaltungMenue, "CSTMMNGM");
		containerPanel.add(panelAutoverwaltungMenue, "CRMNGM");

		/*
		  Logical Part
		 */

		// Lambda Version für Button-Funktionalität.
		bCustomerManagement.addActionListener(e -> {
			/*
			  Sobald der Btn in Action ist, wird panelMainMenue entfernt & panelKundenverwaltungMenue initialisiert.
			 */
			cl.show(containerPanel, "CSTMMNGM");
		});

		bCarManagement.addActionListener(e -> {
			cl.show(containerPanel, "CRMNGM");
		});
		bVerfuegbarkeit.addActionListener(e -> {

			JOptionPane.showMessageDialog(null, "Willkommen im Verfügbarkeits Check!");
		});

		// <<<< Design + Adds Footer General >>>>
		// Definition der Schriftart Footer
		Font schriftartFooter = new Font("Serif", Font.PLAIN + Font.ITALIC, 20);
		textFooter.setFont(schriftartFooter); // legt die Schriftart fest.
		// Das Zentrum des Geschehens - fügt den Text hinzu & platziert ihn im footerPanel
		footerPanel.add(textFooter); // fügt das Text-Label unten hinzu.
		footerPanel.setBackground(Color.RED);

		add(containerPanel);
		setVisible(true); // muss hinter allen adds gesetzt werden, ansonsten treten Probleme auf.
	}
}
