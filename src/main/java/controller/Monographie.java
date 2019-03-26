package controller;

import java.util.HashMap;
import java.util.Map;

public class Monographie implements Quelle {
  Map<String, String> data = new HashMap<String, String>();

  public Monographie(String Name, String Vorname, String Jahr, String Titel, String Herausgeber, String Bindung, String Auflage, String Ort, String Verlag) {
    data.put("Name", Name);
    data.put("Vorname", Vorname);
    data.put("Jahr", Jahr);
    data.put("Titel", Titel);
    data.put("Herausgeber", Herausgeber);
    data.put("Bindung", Bindung);
    data.put("Auflage", Auflage);
    data.put("Ort", Ort);
    data.put("Verlag", Verlag);
  }

  public String toString() {
    if (data == null)
      return "Error. Objekt nicht korrekt erstellt.";

    StringBuffer sb                  = new StringBuffer("");
    String       Name                = data.get("Name");
    String       Vorname             = data.get("Vorname");
    String       Jahr                = data.get("Jahr");
    String       Titel               = data.get("Titel");
    String       Herausgeber         = data.get("Herausgeber");
    boolean      HerausgeberNotEmpty = !Herausgeber.equals("");
    String       Bindung             = data.get("Bindung");
    boolean      BindungNotEmpty     = !Bindung.equals("");
    String       Auflage             = data.get("Auflage");
    boolean      AuflageNotEmpty     = !Auflage.equals("");
    String       Ort                 = data.get("Ort");
    String       Verlag              = data.get("Verlag");

    sb.append(Name + ", " + Vorname + " (" + Jahr + "): " + Titel + ", ");

    if (HerausgeberNotEmpty)
      sb.append(Herausgeber + "(Hrsg.), ");

    if (BindungNotEmpty)
      sb.append("Bd. " + Bindung + ", ");

    if (AuflageNotEmpty)
      sb.append(Auflage + ". Aufl.");

    sb.append(", " + Ort + ": " + Verlag + ".\r\n");

    return sb.toString();
  }
}