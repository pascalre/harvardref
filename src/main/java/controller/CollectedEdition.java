package controller;

public class CollectedEdition extends Source {

  // German: Sammelwerk
  public CollectedEdition(String name, String forename, String year, String contributionTitle, String publisher,
      String title, String binding, String edition, String place, String press, String pageSector) {
    data.put("name", name);
    data.put("forename", forename);
    data.put("year", year);
    data.put("contributionTitle", contributionTitle);
    data.put("publisher", publisher);
    data.put("title", title);
    data.put("binding", binding);
    data.put("edition", edition);
    data.put("place", place);
    data.put("press", press);
    data.put("pageSector", pageSector);
  }

  public String toString() {
    if (data.isEmpty())
      return "Error. Objekt nicht korrekt erstellt.";

    StringBuilder sb = new StringBuilder("");
    String name = data.get("name");
    String forename = data.get("forename");
    String year = data.get("year");
    String contributionTitle = data.get("contributionTitle");
    String publisher = data.get("publisher");
    String title = data.get("title");
    String binding = data.get("binding");
    String edition = data.get("edition");
    String place = data.get("place");
    String press = data.get("press");
    String pageSector = data.get("pageSector");

    sb.append(name + ", " + forename + " (" + year + "): " + contributionTitle + ", in: " + publisher + " (Hrsg.), "
        + title + ", ");

    if (!binding.isEmpty())
      sb.append(" Bd. " + binding + ", ");
    if (!edition.isEmpty())
      sb.append(edition + ". Aufl., ");

    sb.append(place + ": " + press + ", S. " + pageSector + ".\r\n");

    return sb.toString();
  }
}
