/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	JLabel startText;
	JLabel endText;
	JButton bFahrzeugverwaltung, bKundenverwaltung, bVerfuegbarkeit;

	public MainWindow() {

		/*
		 *
		 * Initialisierung & Anpassung Frame & Header
		 */

		setLayout(new BorderLayout());
		setTitle("Car Rental System for S.E. at THB");
		setSize(800, 600);
		setLocationRelativeTo(null); // zentriert das Fenster in die Mitte,
		// muss nach pack() oder setSize ausgefuehrt werden!
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Initialisierung & Anpassung Größe - Start Text
		startText = new JLabel("Verwaltungsprogramm v 1.0");
		startText.setHorizontalAlignment(JLabel.CENTER);
		startText.setVerticalAlignment(JLabel.CENTER);

		// Definition der Schriftart
		Font schriftartHeader = new Font("Serif", Font.PLAIN + Font.ITALIC, 40);
		startText.setFont(schriftartHeader); // legt die Schriftart fest.

		// Führt dazu, dass die Hintergrundfarbe vom Textfeld angezeigt wird.
		startText.setOpaque(true);
		startText.setBackground(Color.gray);

		// Das Zentrum des Geschehens - fügt den Text hinzu & platziert ihn oben.
		add(startText, BorderLayout.NORTH); // fügt das Text-Label oben hinzu.

		// Die Mitte 'center' bekommt ein Panel für die Buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		add(buttonPanel);

		// Black Frame um das ButtonPanel
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		buttonPanel.setBorder(border);

		// Initialisierung Buttons
		bFahrzeugverwaltung = new JButton("Fahrzeugverwaltung");
		bKundenverwaltung = new JButton("Kundenverwaltung");
		bVerfuegbarkeit = new JButton("Verfügbarkeit");

		// Schriftart & Größe der Buttons
		Font schriftartButtons = new Font("Arial", Font.PLAIN, 20);

		bFahrzeugverwaltung.setFont(schriftartButtons);
		bKundenverwaltung.setFont(schriftartButtons);
		bVerfuegbarkeit.setFont(schriftartButtons);

		bKundenverwaltung.setBounds(50, 70, 250, 100);
		bFahrzeugverwaltung.setBounds(50, 200, 250, 100);
		bVerfuegbarkeit.setBounds(50, 330, 250, 100);

		buttonPanel.add(bFahrzeugverwaltung);
		buttonPanel.add(bKundenverwaltung);
		buttonPanel.add(bVerfuegbarkeit);

		/**
		 * Einbindung vom Image
		 */

		JLabel jl = new JLabel();
		jl.setIcon(new ImageIcon("image/autoklein.png"));
		jl.setBounds(350, 100, 400, 300);
		buttonPanel.add(jl);
		validate();

		/**
		 * Handler komplett ersetzt durch Lambdas - steht hier nurnoch für bessere
		 * Nachvollziehbarkeit. Lösung inline-version direkt unter dem auskommentiertem
		 * Bereich:
		 */

		// // Handler verleiht den Buttons seine Funktionalität.
		// DerHandler handler = new DerHandler();
		// // Bevor Klasse DerHandler erstellt und definiert wird,
		// // ActionListener hinzufügen & handler als Objekt übergeben.
		// bFahrzeugverwaltung.addActionListener(handler); // ActionsListener passt auf,
		// ob etwas passiert
		// bKundenverwaltung.addActionListener(handler); // & weiß, was dann zu tun ist.
		// bVerfuegbarkeit.addActionListener(handler);

		// Lambda Version für Button-Funktionalität.
		bKundenverwaltung.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "Willkommen in der Fahrzeugverwaltung!");
		});
		bFahrzeugverwaltung.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "Willkommen in der Kundenverwaltung!");
		});
		bVerfuegbarkeit.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "Willkommen im Verfügbarkeits Check!");
		});

		
		/*
		 * Initialisierung & Anpassung Größe - Footer Text
		 */
		
		endText = new JLabel(
				"Created by: Nico Zahmel, Christopher Alb, " + "Wilhelm Wöhlte, Mirko Reefschläger, Torben Hammes");
		// endText.setHorizontalAlignment(JLabel.RIGHT);
		endText.setVerticalAlignment(JLabel.CENTER);
		endText.setHorizontalAlignment(JLabel.CENTER);

		// Definition der Schriftart
		Font schriftartFooter = new Font("Serif", Font.PLAIN + Font.ITALIC, 19);
		endText.setFont(schriftartFooter); // legt die Schriftart fest.

		// Führt dazu, dass die Hintergrundfarbe vom Textfeld angezeigt wird.
		endText.setOpaque(true);
		endText.setBackground(Color.RED);

		// Das Zentrum des Geschehens - fügt den Text hinzu & platziert ihn unten.
		add(endText, BorderLayout.SOUTH); // fügt das Text-Label unten hinzu.

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

		setVisible(true); // muss hinter allen adds gesetzt werden, ansonsten treten Probleme auf.
	}

	/**
	 * Komplett ersetzt durch Lambdas - steht hier nurnoch für bessere
	 * Nachvollziehbarkeit. Lambda-Version weiter oben.
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
