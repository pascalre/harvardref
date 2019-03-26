package controller;

import java.util.HashMap;
import java.util.Map;

public class Internet implements Quelle {
  Map<String, String> data = new HashMap<String, String>();

  public Internet(String Name, String Vorname, String Jahr, String Titel,
      String Link, String AbrufTag, String AbrufMonat, String AbrufJahr) {
    data.put("Name", Name);
    data.put("Vorname", Vorname);
    data.put("Jahr", Jahr);
    data.put("Titel", Titel);
    data.put("Link", Link);
    data.put("AbrufTag", AbrufTag);
    data.put("AbrufMonat", AbrufMonat);
    data.put("AbrufJahr", AbrufJahr);
  }

  public String toString(){
    if (data == null) return "Error. Objekt nicht korrekt erstellt.";

    StringBuffer sb              = new StringBuffer("");
    String       Name            = data.get("Name");
    boolean      NameNotEmpty    = !Name.equals("");
    String       Vorname         = data.get("Vorname");
    boolean      VornameNotEmpty = !Vorname.equals("");
    String       Jahr            = data.get("Jahr");
    boolean      JahrNotEmpty    = !Jahr.equals("");
    String       Titel           = data.get("Titel");
    String       Link            = data.get("Link");
    String       AbrufTag        = data.get("AbrufTag");
    String       AbrufMonat      = data.get("AbrufMonat");
    String       AbrufJahr       = data.get("AbrufJahr");
    
    if (NameNotEmpty) {
      sb.append(Name);
      if (VornameNotEmpty) sb.append(", "+Vorname);
    }
    
    if (JahrNotEmpty) sb.append(" ("+Jahr+")");
    sb.append(": "); 
      
    sb.append(Titel + ", [online] " + Link + " ["+AbrufTag+"."+AbrufMonat+"."+AbrufJahr+"].\r\n");
    return sb.toString();
  }
}
