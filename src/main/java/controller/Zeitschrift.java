package controller;

import java.util.HashMap;
import java.util.Map;

public class Zeitschrift implements Quelle {
	Map<String, String> data = new HashMap<String, String>();

	public Zeitschrift(String Name, String Vorname, String Jahr,
			String ArtikelTitel, String ZeitschriftTitel, String Jahrgang,
			String Nummer, String Seitenbereich) {
		data.put("Name", Name);
		data.put("Vorname", Vorname);
		data.put("Jahr", Jahr);
		data.put("ArtikelTitel", ArtikelTitel);
		data.put("ZeitschriftTitel", ZeitschriftTitel);
		data.put("Jahrgang", Jahrgang);
		data.put("Nummer", Nummer);
		data.put("Seitenbereich", Seitenbereich);
	}

	public String toString() {
		if (data == null)
			return "Error. Objekt nicht korrekt erstellt.";

		StringBuffer sb = new StringBuffer("");

		String Name = data.get("Name");
		String Vorname = data.get("Vorname");
		String Jahr = data.get("Jahr");
		String ArtikelTitel = data.get("ArtikelTitel");
		String ZeitschriftTitel = data.get("ZeitschriftTitel");
		String Jahrgang = data.get("Jahrgang");
		String Nummer = data.get("Nummer");
		String Seitenbereich = data.get("Seitenbereich");

		sb.append(Name + ", " + Vorname + " (" + Jahr + "):" + ArtikelTitel
				+ ", in: " + ZeitschriftTitel + ", Jg. " + Jahrgang + ", Nr. "
				+ Nummer + ", S. " + Seitenbereich + ".\r\n");

		return sb.toString();
	}
}