package controller;

import java.util.HashMap;
import java.util.Map;

public class Magazine implements Source {
  Map<String, String> data = new HashMap<String, String>();

  // German: Zeitschrift
  public Magazine(String name, String forename, String year, String titleOfArticle, String titleOfMagazine,
      String yeargang, String number, String pageSector) {
    data.put("name", name);
    data.put("forename", forename);
    data.put("year", year);
    data.put("titleOfArticle", titleOfArticle);
    data.put("titleOfMagazine", titleOfMagazine);
    data.put("yeargang", yeargang);
    data.put("number", number);
    data.put("pageSector", pageSector);
  }

  public String toString() {
    if (data.isEmpty())
      return "Error. Objekt nicht korrekt erstellt.";

    StringBuffer sb = new StringBuffer("");
    String name = data.get("name");
    String forename = data.get("forename");
    String year = data.get("year");
    String titleOfArticle = data.get("titleOfArticle");
    String titleOfMagazine = data.get("titleOfMagazine");
    String yeargang = data.get("yeargang");
    String number = data.get("number");
    String pageSector = data.get("pageSector");

    sb.append(name + ", " + forename + " (" + year + "): " + titleOfArticle + ", in: " + titleOfMagazine + ", Jg. "
        + yeargang + ", Nr. " + number + ", S. " + pageSector + ".\r\n");

    return sb.toString();
  }
}