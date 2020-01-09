/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// TODO: 09.01.2020 Package-Namen anpassen.
package system;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
	JPanel footerPanel = new JPanel();  // für alle Menues

	JLabel textHeaderMainMenue = new JLabel("Verwaltungsprogramm v 1.0");
	JLabel textHeaderKundenVerwaltung = new JLabel("Kundenverwaltung");
	JLabel textHeaderFahrzeugVerwaltung = new JLabel("Autoverwaltung");
	JLabel textFooter;

	JButton bFahrzeugverwaltung, bKundenverwaltung, bVerfuegbarkeit;


	// KONSTRUKTOR!
	public MainWindow() {
		/*
		 * Initialisierung & Anpassung JFrame & Title
		 */
		setTitle("Car Rental System for S.E. at THB");
		setSize(800, 600);
		setLocationRelativeTo(null); // zentriert das Fenster in die Mitte,
		// muss nach pack() oder setSize ausgefuehrt werden!
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * 	Initialisierung & Anpassung Größe - Start Label Text
		 *  MainwWindow, Kundenverwaltung, Fahrzeugverwaltung, Verfügbarkeit
 		 */

		// Definition der Schriftart für den Header
		Font schriftartHeader = new Font("Serif", Font.PLAIN + Font.ITALIC, 40);

			// headerMainMenue
		textHeaderMainMenue.setHorizontalAlignment(JLabel.CENTER);
		textHeaderMainMenue.setVerticalAlignment(JLabel.CENTER);
		textHeaderMainMenue.setFont(schriftartHeader); // legt die Schriftart fest.
		headerPanelM.setBackground(Color.GRAY);
		headerPanelM.setOpaque(true);
		headerPanelM.add(textHeaderMainMenue);

			//headerKundenMenue
		textHeaderKundenVerwaltung.setHorizontalAlignment(JLabel.CENTER);
		textHeaderKundenVerwaltung.setVerticalAlignment(JLabel.CENTER);
		textHeaderKundenVerwaltung.setFont(schriftartHeader); // legt die Schriftart fest.
		headerPanelK.setBackground(Color.GRAY);
		headerPanelK.setOpaque(true);
		headerPanelK.add(textHeaderKundenVerwaltung);

		// headerAutoMenue
		textHeaderFahrzeugVerwaltung.setHorizontalAlignment(JLabel.CENTER);
		textHeaderFahrzeugVerwaltung.setVerticalAlignment(JLabel.CENTER);
		textHeaderFahrzeugVerwaltung.setFont(schriftartHeader); // legt die Schriftart fest.
		headerPanelA.setBackground(Color.GRAY);
		headerPanelA.setOpaque(true);
		headerPanelA.add(textHeaderFahrzeugVerwaltung);

		// Die Mitte 'center' bekommt ein Panel für die Buttons
		buttonPanelM.setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLACK); 	// Black Border um das ButtonPanel
		buttonPanelM.setBorder(border);

		// TODO: 09.01.2020 JSPLIT Layout + Back-Button erstellen & integrieren
		// TODO: 09.01.2020 Initialisierung Buttons 1. Menue "Kundenverwaltung": hinz, loesch, bearb
		/*
		Buttons MAINMENUE
		 */
		bKundenverwaltung = new JButton("Kundenverwaltung");
		bFahrzeugverwaltung = new JButton("Fahrzeugverwaltung");
		bVerfuegbarkeit = new JButton("Verfügbarkeit");

		// Schriftart & Größe der Buttons vom MainWindow.
		Font schriftartButtons = new Font("Arial", Font.PLAIN, 20);
		// Zuweisung der Attribute
		bFahrzeugverwaltung.setFont(schriftartButtons);
		bKundenverwaltung.setFont(schriftartButtons);
		bVerfuegbarkeit.setFont(schriftartButtons);

		bKundenverwaltung.setBounds(50, 50, 250, 100);
		bFahrzeugverwaltung.setBounds(50, 180, 250, 100);
		bVerfuegbarkeit.setBounds(50, 310, 250, 100);

		buttonPanelM.add(bFahrzeugverwaltung);
		buttonPanelM.add(bKundenverwaltung);
		buttonPanelM.add(bVerfuegbarkeit);

		/*
		 * Einbindung vom Image mit einem JLabel
		 */
		JLabel jl = new JLabel();
		jl.setIcon(new ImageIcon("image/autoklein.png"));
		jl.setBounds(350, 80, 400, 300);
		buttonPanelM.add(jl);
		//validate();

		/*
		 * Initialisierung & Anpassung Größe - Footer Text
		 */

		textFooter = new JLabel(
		"Created by: Nico Zahmel, Christopher Alb, " + "Wilhelm Wöhlte, Mirko Reefschläger, Torben Hammes");
		// endText.setHorizontalAlignment(JLabel.RIGHT);
/*		endText.setVerticalAlignment(JLabel.CENTER);
		endText.setHorizontalAlignment(JLabel.CENTER);*/

		// Definition der Schriftart
		Font schriftartFooter = new Font("Serif", Font.PLAIN + Font.ITALIC, 19);
		textFooter.setFont(schriftartFooter); // legt die Schriftart fest.

		// Das Zentrum des Geschehens - fügt den Text hinzu & platziert ihn im footerPanel
		footerPanel.add(textFooter); // fügt das Text-Label unten hinzu.
		footerPanel.setBackground(Color.RED);

				/*
		  Definition der Haupt-Ebenen
		 */
		panelMainMenue.setLayout(new BorderLayout());
		panelKundenverwaltungMenue.setLayout(new BorderLayout());
		panelAutoverwaltungMenue.setLayout(new BorderLayout());

		panelMainMenue.add(headerPanelM, BorderLayout.NORTH);
		panelMainMenue.add(buttonPanelM, BorderLayout.CENTER);
		panelMainMenue.add(footerPanel, BorderLayout.SOUTH);

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
			/*
			  Sobald der Btn in Action ist, wird panelMainMenue entfernt & panelKundenverwaltungMenue initialisiert.
			 */
			remove(panelMainMenue);
			add(panelKundenverwaltungMenue);
			panelKundenverwaltungMenue.add(headerPanelK, BorderLayout.NORTH);
			panelKundenverwaltungMenue.add(footerPanel, BorderLayout.SOUTH);
			revalidate();
			repaint();
		});

		bFahrzeugverwaltung.addActionListener(e -> {
			remove(panelMainMenue);
			add(panelAutoverwaltungMenue);
			panelAutoverwaltungMenue.add(headerPanelA, BorderLayout.NORTH);
			panelAutoverwaltungMenue.add(footerPanel, BorderLayout.SOUTH);
			revalidate();
			repaint();
		});
		bVerfuegbarkeit.addActionListener(e -> {
			//JOptionPane.showMessageDialog(null, "Willkommen im Verfügbarkeits Check!");
		});


		add(panelMainMenue);
		setVisible(true); // muss hinter allen adds gesetzt werden, ansonsten treten Probleme auf.
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
