/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// TODO: 09.01.2020 Package-Namen anpassen.
package system;

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

public class MainWindow extends JFrame {
	// Variablendeklaration

	JPanel panelMainMenue = new JPanel();	// Erstellung der Arbeitsflaeche des Hauptmenue-Fensters
	JPanel panelKundenverwaltungMenue  = new JPanel(); // Erstellung des KDVW Menues
	JPanel panelAutoverwaltungMenue = new JPanel();	// Erstellung des AUVW Menues

	JPanel headerPanelM = new JPanel(); // für das MainMenue
	JPanel headerPanelK = new JPanel(); // für das KundenMenue
	JPanel headerPanelA = new JPanel(); // für das AutoMenue
	JPanel buttonPanelM = new JPanel(); // für das MainMenue
	Box buttonPanelMLinks = Box.createVerticalBox(); // ButtonPanelMainLinks
	Box buttonPanelMRechts = Box.createVerticalBox(); // ButtonPanelMainRechts
	JPanel footerPanel = new JPanel();  // für alle Menues

	JLabel textHeaderMainMenue = new JLabel("Verwaltungsprogramm v 1.0");
	JLabel textHeaderKundenVerwaltung = new JLabel("Kundenverwaltung");
	JLabel textHeaderFahrzeugVerwaltung = new JLabel("Autoverwaltung");
	JLabel textFooter = new JLabel(
			"Created by: Nico Zahmel, Christopher Alb, " + "Wilhelm Wöhlte, Mirko Reefschläger, Torben Hammes");

	JButton bKundenverwaltung = new JButton(" Kundenverwaltung  ");
	JButton bFahrzeugverwaltung = new JButton("Fahrzeugverwaltung");
	JButton bVerfuegbarkeit = new JButton("    Verfügbarkeit      ");

	// Definition der Schriftart für den Header
	Font schriftartHeader = new Font("Serif", Font.PLAIN + Font.ITALIC, 40);

	// Schriftart & Größe der Buttons vom MainWindow.
	Font schriftartButtons = new Font("Arial", Font.PLAIN, 20);



/*	KundenverwaltungWindow kundenverwaltung = new KundenverwaltungWindow(this); */
	// >>> Übergabe des Objekts an die Klasse vorerst deaktiviert, bis zur Reaktivierung.

	// KONSTRUKTOR!
	public MainWindow() {
		/*
		 * Initialisierung & Anpassung JFrame & Title
		 */
		setTitle("Car Rental System for S.E. at THB");
		setSize(1024, 768);
		setLocationRelativeTo(null); // zentriert das Fenster in die Mitte,
		// muss nach pack() oder setSize ausgefuehrt werden!
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// <<<< Design + Adds Footer General >>>>
		// Definition der Schriftart Footer
		Font schriftartFooter = new Font("Serif", Font.PLAIN + Font.ITALIC, 20);
		textFooter.setFont(schriftartFooter); // legt die Schriftart fest.
		// Das Zentrum des Geschehens - fügt den Text hinzu & platziert ihn im footerPanel
		footerPanel.add(textFooter); // fügt das Text-Label unten hinzu.
		footerPanel.setBackground(Color.RED);

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
		bFahrzeugverwaltung.setFont(schriftartButtons);
		bKundenverwaltung.setFont(schriftartButtons);
		bVerfuegbarkeit.setFont(schriftartButtons);

/*		bKundenverwaltung.setBounds(50, 59, 250, 100);
		bFahrzeugverwaltung.setBounds(50, 218, 250, 100);
		bVerfuegbarkeit.setBounds(50, 327, 250, 100);*/
		bKundenverwaltung.setPreferredSize(new Dimension(100, 100));
		bFahrzeugverwaltung.setPreferredSize(new Dimension(100, 100));
		bVerfuegbarkeit.setPreferredSize(new Dimension(100, 100));


		// Linkes ButtonPanel

		buttonPanelMLinks.add(Box.createVerticalGlue());
		buttonPanelMLinks.add(bKundenverwaltung);
		buttonPanelMLinks.add(Box.createVerticalGlue());
		buttonPanelMLinks.add(bFahrzeugverwaltung);
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


									// <<<<<< Kundenverwaltung >>>>>>>

		// Content-Panel vom KundenMenue
		panelKundenverwaltungMenue.setLayout(new BorderLayout());

		//headerKundenMenue
		textHeaderKundenVerwaltung.setHorizontalAlignment(JLabel.CENTER);
		textHeaderKundenVerwaltung.setVerticalAlignment(JLabel.CENTER);
		textHeaderKundenVerwaltung.setFont(schriftartHeader); // legt die Schriftart fest.
		headerPanelK.setBackground(Color.GRAY);
		headerPanelK.setOpaque(true);
		headerPanelK.add(textHeaderKundenVerwaltung);
		panelKundenverwaltungMenue.add(headerPanelK, BorderLayout.NORTH);


									// <<<<<< Autoverwaltung >>>>>>>

		// Content-Panel vom AutoverwaltungMenue
		panelAutoverwaltungMenue.setLayout(new BorderLayout());

		// headerAutoMenue
		textHeaderFahrzeugVerwaltung.setHorizontalAlignment(JLabel.CENTER);
		textHeaderFahrzeugVerwaltung.setVerticalAlignment(JLabel.CENTER);
		textHeaderFahrzeugVerwaltung.setFont(schriftartHeader); // legt die Schriftart fest.
		headerPanelA.setBackground(Color.GRAY);
		headerPanelA.setOpaque(true);
		headerPanelA.add(textHeaderFahrzeugVerwaltung);
		panelAutoverwaltungMenue.add(headerPanelA, BorderLayout.NORTH);


									// <<<<<< Mietverwaltung >>>>>>>

		// Swing Timer in Action - war ein Versuch, kann ignoriert werden.
		// final int labelwidth = 800;
		// final AtomicInteger labelPadding = new AtomicInteger();
		// Timer timer = new Timer(20, new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// endText.setBorder(new EmptyBorder(0, 0, 0, labelPadding.getAndIncrement()-
		// labelwidth));
		// }
		// });
		// timer.start();

		/*
		  Logical Part
		 */

		// Lambda Version für Button-Funktionalität.
		bKundenverwaltung.addActionListener(e -> {

/*			kundenverwaltung.open(); <<<<<<<< Bleibt vorerst deaktiviert.*/


			/*
			  Sobald der Btn in Action ist, wird panelMainMenue entfernt & panelKundenverwaltungMenue initialisiert.
			 */
			remove(panelMainMenue);
			panelKundenverwaltungMenue.add(footerPanel, BorderLayout.SOUTH);
			add(panelKundenverwaltungMenue);
			revalidate();
			repaint();
		});

		bFahrzeugverwaltung.addActionListener(e -> {
			remove(panelMainMenue);
			add(panelAutoverwaltungMenue);
			panelAutoverwaltungMenue.add(footerPanel, BorderLayout.SOUTH);
			revalidate();
			repaint();
		});
		bVerfuegbarkeit.addActionListener(e -> {
			//JOptionPane.showMessageDialog(null, "Willkommen im Verfügbarkeits Check!");
		});


		add(panelMainMenue);
		setVisible(true); // muss hinter allen adds gesetzt werden, ansonsten treten Probleme auf.
		System.out.println(buttonPanelMRechts.getSize());
	}

	/*
	  Komplett ersetzt durch Lambdas - steht hier nurnoch für bessere
	  Nachvollziehbarkeit. Lambda-Version weiter oben.
	 */
	// private class DerHandler implements ActionListener {
	//
	// @Override
	// public void actionPerformed(ActionEvent event) {
	// if (event.getSource() == bFahrzeugverwaltung) {
	// // null positioniert die Meldung in der Mitte
	// // danach folgt der Ausgabe-String
	// JOptionPane.showMessageDialog(null, "Willkommen in der Fahrzeugverwaltung");
	// } else if (event.getSource() == bKundenverwaltung) {
	// JOptionPane.showMessageDialog(null, "Willkommen in der Kundenverwaltung");
	// } else if (event.getSource() == bVerfuegbarkeit) {
	// JOptionPane.showMessageDialog(null, "Willkommen im Verfügbarkeits Check");
	// }
	// }
	// }
}
