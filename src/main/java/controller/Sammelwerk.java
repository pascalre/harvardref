package controller;

import java.util.HashMap;
import java.util.Map;

public class Sammelwerk implements Quelle {
  Map<String, String> data = new HashMap<String, String>();

  public Sammelwerk(String Name, String Vorname, String Jahr,
      String BeitragsTitel, String Herausgeber, String Titel,
      String Bindung, String Auflage, String Ort, String Verlag,
      String Seitenbereich) {
    data.put("Name", Name);
    data.put("Vorname", Vorname);
    data.put("Jahr", Jahr);
    data.put("BeitragsTitel", BeitragsTitel);
    data.put("Herausgeber", Herausgeber);
    data.put("Titel", Titel);
    data.put("Bindung", Bindung);
    data.put("Auflage", Auflage);
    data.put("Ort", Ort);
    data.put("Verlag", Verlag);
    data.put("Seitenbereich", Seitenbereich);
  }

  public String toString() {
    if (data == null)
      return "Error. Objekt nicht korrekt erstellt.";

    StringBuffer sb              = new StringBuffer("");
    String       Name            = data.get("Name");
    String       Vorname         = data.get("Vorname");
    String       Jahr            = data.get("Jahr");
    String       BeitragsTitel   = data.get("BeitragsTitel");
    String       Herausgeber     = data.get("Herausgeber");
    String       Titel           = data.get("Titel");
    String       Bindung         = data.get("Bindung");
    boolean      BindungNotEmpty = !Bindung.equals("");
    String       Auflage         = data.get("Auflage");
    boolean      AuflageNotEmpty = !Auflage.equals("");
    String       Ort             = data.get("Ort");
    String       Verlag          = data.get("Verlag");
    String       Seitenbereich   = data.get("Seitenbereich");

    sb.append(Name + ", " + Vorname + " (" + Jahr + "): " + BeitragsTitel
        + ", in: " + Herausgeber + " (Hrsg.), " + Titel + ", ");

    if (BindungNotEmpty)
      sb.append(" Bd. " + Bindung + ", ");
    if (AuflageNotEmpty)
      sb.append(Auflage + ". Aufl., ");

    sb.append(Ort + ": " + Verlag + ", S. " + Seitenbereich + ".\r\n");

    return sb.toString();
  }
}
