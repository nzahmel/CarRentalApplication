package de.thb.fbw.se.fahrzeugverwaltung;

public interface IFahrzeugverwaltung {
	
	public void fHinzufuegen(Fahrzeug fahrzeug);
	
	public void fBearbeiten(Fahrzeug fahrzeug, String fahrzeugkategorie, String hersteller, String modell, String getriebe, 
			String kraftstoff, int kilometerstand);
	
	public void fLoeschen(int index);
	
	public Fahrzeug getFahrzeug(int index);
	
	public void hinzufuegenFahrzeugListener(IFahrzeugListener listener);
	
	public void loeschenFahrzeugListener(IFahrzeugListener listener);

	
	
	
}
