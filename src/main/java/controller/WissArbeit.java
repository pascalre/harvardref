package controller;

import java.util.HashMap;
import java.util.Map;

public class WissArbeit implements Quelle {
	Map<String, String> data = new HashMap<String, String>();

	public WissArbeit(String Name, String Vorname, String Jahr, String Titel,
			String Form, String Fach, String Einrichtung, String Ort) {
		data.put("Name", Name);
		data.put("Vorname", Vorname);
		data.put("Jahr", Jahr);
		data.put("Titel", Titel);
		data.put("Form", Form);
		data.put("Fach", Fach);
		data.put("Einrichtung", Einrichtung);
		data.put("Ort", Ort);
	}

	public String toString() {
		if (data == null)
			return "Error. Objekt nicht korrekt erstellt.";

		StringBuffer sb = new StringBuffer("");

		String Name = data.get("Name");
		String Vorname = data.get("Vorname");
		String Jahr = data.get("Jahr");
		String Titel = data.get("Titel");
		String Form = data.get("Form");
		String Fach = data.get("Fach");
		String Einrichtung = data.get("Einrichtung");
		String Ort = data.get("Ort");
		
		sb.append(Name + ", " + Vorname + " (" + Jahr + "): " + Titel + ", "
				+ Form + " im Fach " + Fach + " d. " + Einrichtung + " in "
				+ Ort + ".\r\n");
		return sb.toString();
	}
}
