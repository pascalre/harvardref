package controller;

import java.util.HashMap;
import java.util.Map;

public class AcademicPaper implements Source {
  Map<String, String> data = new HashMap<String, String>();

  // German: Wissenschaftliche Arbeit
  public AcademicPaper(String name, String forename, String year, String title, String form, String subject,
      String institution, String place) {
    data.put("name", name);
    data.put("forename", forename);
    data.put("year", year);
    data.put("title", title);
    data.put("form", form);
    data.put("subject", subject);
    data.put("institution", institution);
    data.put("place", place);
  }

  public String toString() {
    if (data.isEmpty())
      return "Error. Objekt nicht korrekt erstellt.";

    StringBuffer sb = new StringBuffer("");
    String name = data.get("name");
    String forename = data.get("forename");
    String year = data.get("year");
    String title = data.get("title");
    String form = data.get("form");
    String subject = data.get("subject");
    String institution = data.get("institution");
    String place = data.get("place");

    sb.append(name + ", " + forename + " (" + year + "): " + title + ", " + form + " im Fach " + subject + " d. "
        + institution + " in " + place + ".\r\n");
    return sb.toString();
  }
}
