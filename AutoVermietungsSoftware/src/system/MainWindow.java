/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.awt.*;
import javax.smartcardio.Card;
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
	JPanel headerPanel, buttonPanel, footerPanel;
	JLabel headerMainWindow, headerKundenVerwaltung, headerFahrzeugVerwaltung;
	JLabel endText;
	JButton bFahrzeugverwaltung, bKundenverwaltung, bVerfuegbarkeit;


	//This is a Test
	JPanel contentPanel = new JPanel(); // Erstellung der Arbeitsebene (der Box)
	JPanel panelMain = new JPanel();	// Erstellung der ersten Karte
	JPanel panelKundenverwaltung  = new JPanel(); // Erstellung der Karte KDVW
	JPanel panelAutoverwaltung = new JPanel();	// Erstellung der Karte AUVW
	//Test End

	public MainWindow() {

		/*
		  CardLayout Deklaration der einzelnen Panels/Karten.
		 */
		CardLayout cl = new CardLayout(); // Erstellung des CL Objekts, der Wolke
		contentPanel.setLayout(cl);
		//panelMain.add(headerPanel);



		/*
		 * Initialisierung & Anpassung Frame & Title
		 */
		setLayout(new BorderLayout());
		setTitle("Car Rental System for S.E. at THB");
		setSize(800, 600);
		setLocationRelativeTo(null); // zentriert das Fenster in die Mitte,
		// muss nach pack() oder setSize ausgefuehrt werden!
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * 	Initialisierung & Anpassung Gr��e - Start Label Text
		 *  MainwWindow, Kundenverwaltung, Fahrzeugverwaltung, Verf�gbarkeit
 		 */

		headerPanel = new JPanel();
		add(headerPanel);
		// Definition der Schriftart
		Font schriftartHeader = new Font("Serif", Font.PLAIN + Font.ITALIC, 40);

		// headerKundenVerwaltung
		headerKundenVerwaltung = new JLabel("Kundenverwaltung");
		headerKundenVerwaltung.setHorizontalAlignment(JLabel.CENTER);
		headerKundenVerwaltung.setVerticalAlignment(JLabel.CENTER);
		// Definition der Schriftart
		headerKundenVerwaltung.setFont(schriftartHeader); // legt die Schriftart fest.
		// F�hrt dazu, dass die Hintergrundfarbe vom Textfeld angezeigt wird.
		headerKundenVerwaltung.setOpaque(true);
		headerKundenVerwaltung.setBackground(Color.gray);
		// Das Zentrum des Geschehens - f�gt den Text hinzu & platziert ihn oben.
		headerPanel.add(headerKundenVerwaltung, BorderLayout.NORTH); // f�gt das Text-Label oben hinzu.

			// headerMainWindow
		headerMainWindow = new JLabel("Verwaltungsprogramm v 1.0");
		headerMainWindow.setHorizontalAlignment(JLabel.CENTER);
		headerMainWindow.setVerticalAlignment(JLabel.CENTER);
		headerMainWindow.setFont(schriftartHeader); // legt die Schriftart fest.
		// F�hrt dazu, dass die Hintergrundfarbe vom Textfeld angezeigt wird.
		headerMainWindow.setOpaque(true);
		headerMainWindow.setBackground(Color.gray);
		// Das Zentrum des Geschehens - f�gt den Text hinzu & platziert ihn oben.
		add(headerMainWindow, BorderLayout.NORTH); // f�gt das Text-Label oben hinzu.

		// Die Mitte 'center' bekommt ein Panel f�r die Buttons
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		add(buttonPanel);
		// Black Border um das ButtonPanel
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		buttonPanel.setBorder(border);

		// Initialisierung Buttons
		bKundenverwaltung = new JButton("Kundenverwaltung");
		bFahrzeugverwaltung = new JButton("Fahrzeugverwaltung");
		bVerfuegbarkeit = new JButton("Verf�gbarkeit");

		// Schriftart & Gr��e der Buttons vom MainWindow.
		Font schriftartButtons = new Font("Arial", Font.PLAIN, 20);
		// Zuweisung der Attribute
		bFahrzeugverwaltung.setFont(schriftartButtons);
		bKundenverwaltung.setFont(schriftartButtons);
		bVerfuegbarkeit.setFont(schriftartButtons);

		bKundenverwaltung.setBounds(50, 70, 250, 100);
		bFahrzeugverwaltung.setBounds(50, 200, 250, 100);
		bVerfuegbarkeit.setBounds(50, 330, 250, 100);

		buttonPanel.add(bFahrzeugverwaltung);
		buttonPanel.add(bKundenverwaltung);
		buttonPanel.add(bVerfuegbarkeit);


		/*
		 * Einbindung vom Image mit einem JLabel
		 */
		JLabel jl = new JLabel();
		jl.setIcon(new ImageIcon("image/autoklein.png"));
		jl.setBounds(350, 100, 400, 300);
		buttonPanel.add(jl);
		//validate();

		/*
		 * Initialisierung & Anpassung Gr��e - Footer Text
		 */
		footerPanel = new JPanel();

		endText = new JLabel(
		"Created by: Nico Zahmel, Christopher Alb, " + "Wilhelm W�hlte, Mirko Reefschl�ger, Torben Hammes");
		// endText.setHorizontalAlignment(JLabel.RIGHT);
/*		endText.setVerticalAlignment(JLabel.CENTER);
		endText.setHorizontalAlignment(JLabel.CENTER);*/
		add(footerPanel, BorderLayout.SOUTH);
		footerPanel.setBackground(Color.RED);

		// Definition der Schriftart
		Font schriftartFooter = new Font("Serif", Font.PLAIN + Font.ITALIC, 19);
		endText.setFont(schriftartFooter); // legt die Schriftart fest.

		// F�hrt dazu, dass die Hintergrundfarbe vom Textfeld angezeigt wird.
		endText.setOpaque(true);
		endText.setBackground(Color.RED);

		// Das Zentrum des Geschehens - f�gt den Text hinzu & platziert ihn unten.
		footerPanel.add(endText); // f�gt das Text-Label unten hinzu.

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

		/*
		 * Handler komplett ersetzt durch Lambdas - steht hier nurnoch f�r bessere
		 * Nachvollziehbarkeit. L�sung inline-version direkt unter dem auskommentiertem
		 * Bereich:
		 */

		// // Handler verleiht den Buttons seine Funktionalit�t.
		// DerHandler handler = new DerHandler();
		// // Bevor Klasse DerHandler erstellt und definiert wird,
		// // ActionListener hinzuf�gen & handler als Objekt �bergeben.
		// bFahrzeugverwaltung.addActionListener(handler); // ActionsListener passt auf,
		// ob etwas passiert
		// bKundenverwaltung.addActionListener(handler); // & wei�, was dann zu tun ist.
		// bVerfuegbarkeit.addActionListener(handler);



		// Lambda Version f�r Button-Funktionalit�t.
		bKundenverwaltung.addActionListener(e -> {
			/*
			  Sobald der Btn in Action ist, wird headerMainWinndow verdeckt & headerKundenVerwaltung aufgedeckt.
			 */
			headerPanel.setVisible(false);

			//JOptionPane.showMessageDialog(null, "Willkommen in der Fahrzeugverwaltung!");
		});
		bFahrzeugverwaltung.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, Main.wichtigeInformation);
			headerPanel.setVisible(true);
		});
		bVerfuegbarkeit.addActionListener(e -> {
			bFahrzeugverwaltung.setVisible(true);
			JOptionPane.showMessageDialog(null, "Willkommen im Verf�gbarkeits Check!");
		});

		setVisible(true); // muss hinter allen adds gesetzt werden, ansonsten treten Probleme auf.
	}

	/*
	  Komplett ersetzt durch Lambdas - steht hier nurnoch f�r bessere
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
	// JOptionPane.showMessageDialog(null, "Willkommen im Verf�gbarkeits Check");
	// }
	// }
	// }
}
