package de.thb.fbw.se.fahrzeugverwaltung;

import java.util.*;





public class Fahrzeugverwaltung implements IFahrzeugverwaltung{

	private Map<String, Fahrzeug> fahrzeug;
	private List<Fahrzeug> fahrzeuglist;
	
	private Set<IFahrzeugListener> listeners;
	
	public Fahrzeugverwaltung() {
		fahrzeuglist = new ArrayList<>();
		fahrzeug = new HashMap<>();
		listeners = new HashSet<>();
	}

	public void fHinzufuegen(Fahrzeug fahrzeug) {
		this.fahrzeug.put(fahrzeug.getId(), fahrzeug);
		fahrzeuglist.add(fahrzeug);
		for (IFahrzeugListener listener : listeners)
			listener.fahrzeugChanged();

	}
		
	public Fahrzeug getfahrzeug(String id) {
			fahrzeug.put(id, null);
			fahrzeug.containsKey(id);
			/*for (Map.Entry<String, Fahrzeug> entry : fahrzeug.entrySet()) {
				entry.getValue();
			}*/
			return fahrzeug.get(id);
			
	}
	
	public Fahrzeug getFahrzeug(int index) {
		return fahrzeuglist.get(index);
	}
	
	public int getFahrzeugCount() {
		return fahrzeug.size();
	}
	
	

	public void fBearbeiten(Fahrzeug fahrzeug, String fahrzeugkategorie, String hersteller, String modell, String getriebe, 
			String kraftstoff, int kilometerstand) {
		fahrzeug.setFahrzeukategorie(fahrzeugkategorie);
		fahrzeug.setHersteller(hersteller);
		fahrzeug.setModell(modell);
		fahrzeug.setGetriebe(getriebe);
		fahrzeug.setKraftstoff(kraftstoff);
		fahrzeug.setKilometerstand(kilometerstand);
	}
	public Fahrzeug fBearbeiten(int index) {
		return fahrzeuglist.get(index);
		
		
	}

	public void fLoeschen(int index) {
		fahrzeuglist.remove(index);
		
		
	}
	
	public void fListeAnzeigen( ) {
		for (Fahrzeug fahrzeug : fahrzeuglist) {
			System.out.println(fahrzeug.getId() +" "+ fahrzeug.getFahrzeukategorie() +" "
			+ fahrzeug.getHersteller() +" "+ fahrzeug.getModell() +" "+ fahrzeug.getGetriebe() 
			+" "+ fahrzeug.getKraftstoff() +" "+ fahrzeug.getKilometerstand());
		}
	}
	public void fGroeße() {
		System.out.println(fahrzeuglist.size());
	}
	public void hinzufuegenFahrzeugListener(IFahrzeugListener listener) {
		listeners.add(listener);
	}
	
	public void loeschenFahrzeugListener(IFahrzeugListener listener) {
		listeners.remove(listener);
	}
}	
	