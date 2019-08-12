package controller;

public class Monograph extends Source {

  public Monograph(String name, String forename, String year, String title, String publisher, String binding,
      String edition, String place, String press) {
    data.put("name", name);
    data.put("forename", forename);
    data.put("year", year);
    data.put("title", title);
    data.put("publisher", publisher);
    data.put("binding", binding);
    data.put("edition", edition);
    data.put("place", place);
    data.put("press", press);
  }

  public String toString() {
    if (data.isEmpty())
      return "Error. Objekt nicht korrekt erstellt.";

    StringBuilder sb = new StringBuilder("");
    String name = data.get("name");
    String forename = data.get("forename");
    String year = data.get("year");
    String title = data.get("title");
    String publisher = data.get("publisher");
    String binding = data.get("binding");
    String edition = data.get("edition");
    String place = data.get("place");
    String press = data.get("press");

    sb.append(name + ", " + forename + " (" + year + "): " + title + ", ");

    if (!publisher.isEmpty())
      sb.append(publisher + " (Hrsg.), ");

    if (!binding.isEmpty())
      sb.append("Bd. " + binding + ", ");

    if (!edition.isEmpty())
      sb.append(edition + ". Aufl.");

    sb.append(", " + place + ": " + press + ".\r\n");

    return sb.toString();
  }
}