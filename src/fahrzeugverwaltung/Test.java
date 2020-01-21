package fahrzeugverwaltung;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		Fahrzeug eins = new Fahrzeug();
		eins.setFahrzeukategorie("PKW");
		eins.setGetriebe("manuell");
		eins.setHersteller("BMW");
		
		eins.setKilometerstand(0);
		eins.setKraftstoff("Benzin");
		eins.setModell("3er e46");
		
		Fahrzeug zwei = new Fahrzeug();
		zwei.setFahrzeukategorie("PKW");
		zwei.setGetriebe("automatik");
		zwei.setHersteller("Audi");
		
		zwei.setKilometerstand(200);
		zwei.setKraftstoff("Diesel");
		zwei.setModell("A3");
		
		System.out.println(eins);
		
		System.out.println("Fahrzeugkategorie: "+ eins.getFahrzeukategorie());
		System.out.println("Getriebe: " + eins.getGetriebe());
		System.out.println("Hersteller: " + eins.getHersteller());
		System.out.println("Id: " + eins.getId());
		System.out.println("Kilometerstand: " + eins.getKilometerstand() + "km");
		System.out.println("Kraftstoff: " + eins.getKraftstoff());
		System.out.println("Modell: " + eins.getModell());
	
		System.out.println();
		
		System.out.println("Fahrzeugkategorie: "+ zwei.getFahrzeukategorie());
		System.out.println("Getriebe: " + zwei.getGetriebe());
		System.out.println("Hersteller: " + zwei.getHersteller());
		System.out.println("Id: " + zwei.getId());
		System.out.println("Kilometerstand: " + zwei.getKilometerstand() + "km");
		System.out.println("Kraftstoff: " + zwei.getKraftstoff());
		System.out.println("Modell: " + zwei.getModell());
		
		Fahrzeugverwaltung drei = new Fahrzeugverwaltung();
		Fahrzeug vier = new Fahrzeug();
		Fahrzeug fünf = new Fahrzeug("PKW", "Mercedes", "C63 AMG", "automatik", "Diesel", 0);
		Fahrzeug sechs = new Fahrzeug();
		System.out.println(fünf.getFahrzeukategorie());
		
		drei.fListeAnzeigen();
		System.out.println("Fahrzeug hinzugefügt mit leerem Construktor, aber mit Inhalt");
		drei.fHinzufügen(eins);
		drei.fListeAnzeigen();
		System.out.println("----");
		System.out.println("Zweites Fahrzeug hinzugefügt");
		drei.fHinzufügen(zwei);
		drei.fListeAnzeigen();
		System.out.println("-----");
		System.out.println("Drittes Fahrzeug hinzugefügt mit leerem Construktor");
		drei.fHinzufügen(vier);
		drei.fListeAnzeigen();
		System.out.println("-----");
		System.out.println("4tes Fahrzeug hinzugefügt mit definiertem Construktor");
		drei.fHinzufügen(fünf);
		drei.fListeAnzeigen();
		System.out.println("------");
		System.out.println(sechs);
		drei.fLoeschen(0);
		drei.fListeAnzeigen();
		System.out.println("----");
		/*System.out.println(sechs);
		System.out.println(drei.getFahrzeug(1));
		System.out.println("-----");
		drei.fLoeschen(zwei);
		drei.fListeAnzeigen();
		System.out.println("---");
		drei.fBearbeiten(vier, "PKW", "BMW", "7er", "automatik", "Benzin",300);
		drei.fListeAnzeigen();
		*/
		System.out.println(drei.getFahrzeug(1));
		System.out.println(drei.fbearbeiten(1));
		
	}
}
