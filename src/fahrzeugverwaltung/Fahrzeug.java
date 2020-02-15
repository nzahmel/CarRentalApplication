package fahrzeugverwaltung;

import java.io.Serializable;
import java.util.UUID;


public class Fahrzeug {
	private String Id;
	private String hersteller;
	private String modell;
	private String getriebe;
	private String kraftstoff;
	private String fahrzeugkategorie;
	private int kilometerstand;
	
	public Fahrzeug() {
		Id = UUID.randomUUID().toString();
	}
	
	public Fahrzeug(String fahrzeugkategorie, String hersteller, String modell, String getriebe, 
			String kraftstoff, int kilometerstand) {
		
		Id = UUID.randomUUID().toString();
		this.fahrzeugkategorie = fahrzeugkategorie;
		this.hersteller = hersteller;
		this.modell = modell;
		this.getriebe = getriebe;
		this.kraftstoff = kraftstoff;
		this.kilometerstand = kilometerstand;
	}
	//Constructor//
	/*public Fahrzeug() {
			
	}*/
	
	/*public Fahrzeug(Fahrzeug original) {
		Id = original.Id;
		hersteller = original.hersteller;
		modell = original.modell;
		getriebe = original.getriebe;
		kraftstoff = original.kraftstoff;
		fahrzeugkategorie = original.fahrzeugkategorie;
		kilometerstand = original.kilometerstand;
		
	}*/
		
	
	
	public String getId() {
		return Id;
	}
	
	public void setId(String id) {
		this.Id = id;
	}
	
	public String getHersteller() {
		return hersteller;
	}
	
	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}
	
	public String getModell() {
		return modell;
	}
	
	public void setModell(String modell) {
		this.modell = modell;
	}
	
	public String getGetriebe() {
		return getriebe;
	}
	
	public void setGetriebe(String getriebe) {
		this.getriebe = getriebe;
	}
	
	public String getKraftstoff() {
		return kraftstoff;
	}
	
	public void setKraftstoff(String kraftstoff) {
		this.kraftstoff = kraftstoff;
	}
	
	public String getFahrzeukategorie() {
		return fahrzeugkategorie;
	}
	
	public void setFahrzeukategorie(String fahrzeukategorie) {
		this.fahrzeugkategorie = fahrzeukategorie;
	}
	
	public int getKilometerstand() {
		return kilometerstand;
	}
	
	public void setKilometerstand(int kilometerstand) {
		this.kilometerstand = kilometerstand;
	}

	// Gibt die einzelnen Values des jeweiligen Objekts auf der Konsole aus
	@Override
	public String toString() {
		return "Fahrzeug{" +
				"Id='" + Id + '\'' +
				", hersteller='" + hersteller + '\'' +
				", modell='" + modell + '\'' +
				", getriebe='" + getriebe + '\'' +
				", kraftstoff='" + kraftstoff + '\'' +
				", fahrzeugkategorie='" + fahrzeugkategorie + '\'' +
				", kilometerstand=" + kilometerstand +
				'}';
	}

	public int hashCode() {
		return Id.hashCode();
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Fahrzeug) {
			Fahrzeug otherFahrzeug = (Fahrzeug) obj;
			return Id.equals(otherFahrzeug.getId());
		}
		return false;
	}
	
}
