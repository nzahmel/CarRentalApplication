package de.thb.fbw.se.gui;

import javax.swing.table.AbstractTableModel;

import fahrzeugverwaltung.IFahrzeugListener;
import fahrzeugverwaltung.IFahrzeugverwaltung;

public class FahrzeugTable extends AbstractTableModel {
	private static String[] COLUMN_TITLES = new String[] { "ID", "Fahrzeugkategorie", "Hersteller", "Modell", "Getriebe"
			, "Kraftstoff", "Kilometerstand"};
	
	private IFahrzeugverwaltung fahrzeugverwaltung;
	
	public FahrzeugTable(IFahrzeugverwaltung fahrzeugverwaltung) {
		this.fahrzeugverwaltung = fahrzeugverwaltung;
		fahrzeugverwaltung.hinzufügenFahrzeugListener(new IFahrzeugListener() {
			
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

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getColumnName(int column) {
		System.out.println("Column name " + column);
		return COLUMN_TITLES[column];
	}
}
