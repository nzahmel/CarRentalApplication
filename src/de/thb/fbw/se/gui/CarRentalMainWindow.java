/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.thb.fbw.se.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Nico Zahmel <Enjoy the flight>
 * @version 1.0 image source: <a href=
 *          "https://www.freepik.com/free-photos-vectors/background">Background
 *          vector created by rawpixel.com - www.freepik.com</a>
 */

public class CarRentalMainWindow extends JFrame {

	// Deklaration & Initialisierung der Hauptpanel
	CardLayout cl = new CardLayout();
	JPanel containerPanel = new JPanel();
	JPanel panelMainMenue = new JPanel();	// Erstellung der Arbeitsflaeche des Hauptmenue-Fensters
	JPanel panelKundenverwaltungMenue  = new CustomerManagement(this); //new JPanel(); // Erstellung des KDVW Menues
	JPanel panelAutoverwaltungMenue = new CarManagement(this);	// Erstellung des AUVW Menues
	JPanel panelVerfuegbarkeitMenue = new Availability(this);

	// Deklaration & Initialisierung der 2nd Level Panel
	JPanel headerPanelM = new JPanel(); // f�r das MainMenue
	JPanel buttonPanelM = new JPanel(); // f�r das MainMenue
	Box buttonPanelMLinks = Box.createVerticalBox(); // ButtonPanelMainLinks
	Box buttonPanelMRechts = Box.createVerticalBox(); // ButtonPanelMainRechts
	JPanel footerPanel = new JPanel();  // f�r alle Menues
	// Deklaration der Labels f�r die 2nd Level Panel
	JLabel textHeaderMainMenue;
	JLabel textFooter;
	// Deklaration der Buttons vom Hauptmenue
	JButton bCustomerManagement;
	JButton bCarManagement;
	JButton bVerfuegbarkeit;

	// Definition der Schriftart f�r den Header
	Font schriftartHeader = new Font("Serif", Font.PLAIN + Font.ITALIC, 40);
	// Schriftart & Gr��e der Buttons vom MainWindow.
	Font schriftartButtons = new Font("Arial", Font.PLAIN, 20);


	///////////////// KONSTRUKTOR!

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
		setLayout(new BorderLayout());



		/*
		* Dies ist der Hauptcontainer, in dem alle Menues in Form von "Karten" (einzelnen Panels) angelegt werden.
		*/
		containerPanel.setLayout(cl);


		/////////////////////////////////////////////////////////////////////////////////////

		/*
		  Style + Adds der Elemente der Seiten:
		 */

									// <<<<<< Verwaltung MainMenue >>>>>>>

		// Content-Panel vom MainMenue
		panelMainMenue.setLayout(new BorderLayout());

		// Initialisierung HeaderMainMenue
		textHeaderMainMenue = new JLabel("Verwaltungsprogramm v 1.0");
		textHeaderMainMenue.setHorizontalAlignment(JLabel.CENTER);
		textHeaderMainMenue.setVerticalAlignment(JLabel.CENTER);
		textHeaderMainMenue.setFont(schriftartHeader); // legt die Schriftart fest.
		headerPanelM.setBackground(Color.GRAY);
		headerPanelM.setOpaque(true);
		headerPanelM.add(textHeaderMainMenue);

		// Die Mitte 'center' bekommt ein Panel f�r die Buttons
		buttonPanelM.setLayout(new GridLayout(1, 2));
		Border border = BorderFactory.createLineBorder(Color.BLACK); 	// Black Border um das ButtonPanel
		buttonPanelM.setBorder(border);


		// ---- Buttons MAINMENUE


		// Zuweisung der Attribute der Buttons von MainMenue
		bCustomerManagement = new JButton(" Kundenverwaltung  ");
		bCarManagement = new JButton("Fahrzeugverwaltung");
		bVerfuegbarkeit = new JButton("    Verf�gbarkeit      ");
		bCarManagement.setFont(schriftartButtons);
		bCustomerManagement.setFont(schriftartButtons);
		bVerfuegbarkeit.setFont(schriftartButtons);
		bCustomerManagement.setPreferredSize(new Dimension(100, 100));
		bCarManagement.setPreferredSize(new Dimension(100, 100));
		bVerfuegbarkeit.setPreferredSize(new Dimension(100, 100));


		// ----- Linkes ButtonPanel

		buttonPanelMLinks.add(Box.createVerticalGlue());
		buttonPanelMLinks.add(bCustomerManagement);
		buttonPanelMLinks.add(Box.createVerticalGlue());
		buttonPanelMLinks.add(bCarManagement);
		buttonPanelMLinks.add(Box.createVerticalGlue());
		buttonPanelMLinks.add(bVerfuegbarkeit);
		buttonPanelMLinks.add(Box.createVerticalGlue());
		buttonPanelM.add(buttonPanelMLinks);



		// -----  Einbindung vom Image via JLabel MainMenue

		JLabel jl = new JLabel();
		jl.setIcon(new ImageIcon("image/autoklein.png"));
		jl.setPreferredSize(new Dimension(500, 350));
		jl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 200));
		buttonPanelMRechts.add(Box.createVerticalGlue());
		buttonPanelMRechts.add(jl);
		buttonPanelMRechts.add(Box.createVerticalGlue());
		buttonPanelM.add(buttonPanelMRechts);

		// FINAL ADDS:
		//panelMainMenue.add(headerPanelM, BorderLayout.NORTH);
		panelMainMenue.add(buttonPanelM, BorderLayout.CENTER);
		add(footerPanel, BorderLayout.SOUTH);
		panelMainMenue.add(headerPanelM, BorderLayout.NORTH);

		containerPanel.add(panelMainMenue, "RNTLMAIN");
		// Definiert die per default oberste Karte (Startseite) im Card Layout System
		cl.show(containerPanel, "RNTLMAIN");
		containerPanel.add(panelKundenverwaltungMenue, "CSTMMNGM");
		containerPanel.add(panelAutoverwaltungMenue, "CRMNGM");
		containerPanel.add(panelVerfuegbarkeitMenue, "VRFGBRKT");

		/*
		  Logical Part Button Funktionalit�t
		 */

		// Lambda Version f�r Button-Funktionalit�t.
		bCustomerManagement.addActionListener(e -> {
			// Bei Aktivierung des Buttons wird die Karte "CTSMMNGM" angezeigt.
			cl.show(containerPanel, "CSTMMNGM");
		});

		bCarManagement.addActionListener(e -> {
			cl.show(containerPanel, "CRMNGM");
		});
		bVerfuegbarkeit.addActionListener(e -> {
			cl.show(containerPanel, "VRFGBRKT");
		});

		// <<<< Design + Adds Footer General >>>>
		textFooter = new JLabel(
				"Created by: Nico Zahmel, Christopher Alb, " + "Wilhelm W�hlte, Mirko Reefschl�ger, Torben Hammes");
		// Definition der Schriftart Footer
		Font schriftartFooter = new Font("Serif", Font.PLAIN + Font.ITALIC, 20);
		textFooter.setFont(schriftartFooter); // legt die Schriftart fest.
		// Das Zentrum des Geschehens - f�gt den Text hinzu & platziert ihn im footerPanel
		footerPanel.add(textFooter); // f�gt das Text-Label unten hinzu.
		footerPanel.setBackground(Color.RED);

		add(containerPanel);
		setVisible(true); // muss hinter allen adds gesetzt werden, ansonsten treten Probleme auf.
	}
}
