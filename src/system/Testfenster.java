package system;

import javax.swing.*;
import java.awt.*;

public class Testfenster extends JPanel
{

    JPanel panelKundenverwaltungMenue  = new JPanel(); // Erstellung des KDVW Menues
    JPanel headerPanelK = new JPanel(); // für das KundenMenue
    JLabel textHeaderKundenVerwaltung = new JLabel("Kundenverwaltung");

    // Die Liste im Center
    JPanel linksPanel = new JPanel();
    String[] strSender = {"Auto 1", "Auto2", "Auto3", "Auto4", "Auto5", "Auto6", "Auto7", "Auto8"
            , "Auto2", "Auto3", "Auto4", "Auto5", "Auto6", "Auto7", "Auto8"
            , "Auto2", "Auto3", "Auto4", "Auto5", "Auto6", "Auto7", "Auto8"
            , "Auto2", "Auto3", "Auto4", "Auto5", "Auto6", "Auto7", "Auto8"
            , "Auto2", "Auto3", "Auto4", "Auto5", "Auto6", "Auto7", "Auto8"

    };
    JList list = new JList(strSender);
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

    JPanel footerPanel = new JPanel();  // für alle Menues
    JLabel textFooter = new JLabel(
            "Created by: Nico Zahmel, Christopher Alb, " + "Wilhelm Wöhlte, Mirko Reefschläger, Torben Hammes");



    public Testfenster(){

        /*
         * Initialisierung & Anpassung JFrame & Title
         */
        //setTitle("Car Rental System for S.E. at THB");
        //setSize(1024, 768);
        //setLocationRelativeTo(null); // zentriert das Fenster in die Mitte,
        // muss nach pack() oder setSize ausgefuehrt werden!
        //setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Definition der Schriftart für den Header
        Font schriftartHeader = new Font("Serif", Font.PLAIN + Font.ITALIC, 40);
        // Schriftart & Größe der Buttons vom MainWindow.
        Font schriftartButtons = new Font("Arial", Font.PLAIN, 20);
        // Schriftart & Größe vom PanelLinks (Liste/Tabelle)
        Font schriftArtListe= new Font("Arial", Font.PLAIN, 20);



        // DESIGN! //

        // panelKundenverwaltungMenue Design
        panelKundenverwaltungMenue.setLayout(new BorderLayout());

        //headerKundenMenue
        textHeaderKundenVerwaltung.setHorizontalAlignment(JLabel.CENTER);
        textHeaderKundenVerwaltung.setVerticalAlignment(JLabel.CENTER);
        textHeaderKundenVerwaltung.setFont(schriftartHeader); // legt die Schriftart fest.
        headerPanelK.setBackground(Color.GRAY);
        headerPanelK.setOpaque(true);

        // Liste Links
        linksPanel.setLayout(new BorderLayout());
        list.setFont(schriftArtListe);

        // rechtsPanel
        rechtsPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout(3, 1));

        // Buttons rechts oben: anlegen, bearbeiten, hinzufügen.
        anlegeButton.setFont(schriftartButtons);
        anlegeButton.setPreferredSize(new Dimension(90, 50));
        bearbeitenButton.setFont(schriftartButtons);
        entferneButton.setFont(schriftartButtons);

        // Zurück-Button rechts unten
        zurueckButton.setFont(schriftartButtons);
        zurueckButton.setPreferredSize(new Dimension(90, 50));


        // Footer
        // <<<< Design + Adds Footer General >>>>
        // Definition der Schriftart Footer
        Font schriftartFooter = new Font("Serif", Font.PLAIN + Font.ITALIC, 19);
        textFooter.setFont(schriftartFooter); // legt die Schriftart fest.
        footerPanel.setBackground(Color.RED);
        // ENDE <<<< Design Footer General >>>> ENDE

        // ADDS
        headerPanelK.add(textHeaderKundenVerwaltung);

        // PanelLinks + Liste
        linksPanel.add(new JScrollPane(list));
        //linksPanel.add(list, BorderLayout.CENTER);

        // Buttons rechts oben im buttonPanel: anlegen, bearbeiten, hinzufügen.
        buttonPanel.add(anlegeButton);
        buttonPanel.add(bearbeitenButton);
        buttonPanel.add(entferneButton);
        rechtsPanel.add(buttonPanel, BorderLayout.NORTH);
        rechtsPanel.add(zurueckButton, BorderLayout.SOUTH);

        footerPanel.add(textFooter); // fügt das Text-Label unten hinzu.

        panelKundenverwaltungMenue.add(headerPanelK, BorderLayout.NORTH);
        panelKundenverwaltungMenue.add(linksPanel, BorderLayout.CENTER);
        panelKundenverwaltungMenue.add(rechtsPanel, BorderLayout.EAST);
        panelKundenverwaltungMenue.add(footerPanel, BorderLayout.SOUTH);

        add(panelKundenverwaltungMenue);
        revalidate();
        repaint();
        setVisible(true);
    }

/*    public static void main(String[] args) {
        new Testfenster();

    }*/

/*    public void open(){

        //remove(panelMainMenue);
        add(panelKundenverwaltungMenue);
        revalidate();
        repaint();
    }*/

}
