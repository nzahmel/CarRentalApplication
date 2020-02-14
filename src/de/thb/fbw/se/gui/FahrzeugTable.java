package de.thb.fbw.se.gui;

import javax.swing.table.AbstractTableModel;


import fahrzeugverwaltung.Fahrzeug;
import fahrzeugverwaltung.Fahrzeugverwaltung;
import fahrzeugverwaltung.IFahrzeugListener;
import fahrzeugverwaltung.IFahrzeugverwaltung;

public class FahrzeugTable extends AbstractTableModel {
	private static String[] COLUMN_TITLES = new String[] { "ID", "Fahrzeugkategorie", "Hersteller", "Modell", "Getriebe"
			, "Kraftstoff", "Kilometerstand"};
	
	private IFahrzeugverwaltung fahrzeugverwaltung;
	
	public FahrzeugTable(IFahrzeugverwaltung fahrzeugverwaltung) {
		this.fahrzeugverwaltung = fahrzeugverwaltung;
		fahrzeugverwaltung.hinzufuegenFahrzeugListener(new IFahrzeugListener() {
			
			
			public void fahrzeugChanged() {
				fireTableStructureChanged();
			}
		});
		
	}
	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Object getValueAt(int row, int col) {
		Object ret = null;
		Fahrzeug fahrzeug = fahrzeugverwaltung.getFahrzeug(row);
		switch (col) {
			case 0:
				ret = fahrzeug.getId();
				break;
			case 1:
			default:
				ret = fahrzeug.getFahrzeukategorie();
				break;
			case 2:
				ret = fahrzeug.getHersteller();
				break;
			case 3:
				ret = fahrzeug.getModell();
				break;
			case 4:
				ret = fahrzeug.getGetriebe();
				break;
			case 5:
				ret = fahrzeug.getKraftstoff();
				break;
			case 6:
				ret = fahrzeug.getKilometerstand();
		}
		return ret;
	}
	
	
}
