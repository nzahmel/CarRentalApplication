package fahrzeugverwaltung;

public interface IFahrzeugverwaltung {
	
	public void fHinzuf�gen(Fahrzeug fahrzeug);
	
	public void fBearbeiten(Fahrzeug fahrzeug, String fahrzeugkategorie, String hersteller, String modell, String getriebe, 
			String kraftstoff, int kilometerstand);
	
	public void fLoeschen(int index);
	
	
}
